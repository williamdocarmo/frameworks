package com.movie.movieinfoservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieInfoResource.class);
	
	private static Map<String, String> movieMaps;
	
	static {
		movieMaps = new HashMap<String, String>();
		movieMaps.put("mv1", "Batman Begins");
		movieMaps.put("mv2", "The Dark Knight");
		movieMaps.put("mv3", "The Dark Knight Rises");
	}

	@RequestMapping("/{movieId}")
	public Movie getMovies(@PathVariable(name = "movieId") String id) {
		logger.info("getMovies Invoked");
		return new Movie(id, movieMaps.get(id));
	}

}
