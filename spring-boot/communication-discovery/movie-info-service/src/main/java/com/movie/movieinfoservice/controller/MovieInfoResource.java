package com.movie.movieinfoservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	private static final Logger logger = LoggerFactory.getLogger(MovieInfoResource.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.url}")
	private String apiUrl;

	@RequestMapping("/{movieId}")
	public MovieSummary getMovies(@PathVariable(name = "movieId") String id) {
		logger.info("getMovies Invoked "+id);
		if (id.equals("553") || id.equals("551")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String url = String.format(apiUrl, id);
		MovieSummary m = restTemplate.getForObject(url, MovieSummary.class);
		return m;
	}

}
