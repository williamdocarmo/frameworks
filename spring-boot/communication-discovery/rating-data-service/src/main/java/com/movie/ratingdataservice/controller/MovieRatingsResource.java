package com.movie.ratingdataservice.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ratingdataservice.model.Rating;
import com.movie.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class MovieRatingsResource {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieRatingsResource.class);

	private static Map<String, Integer> ratingsMapByMovie;

	static {
		ratingsMapByMovie = new HashMap<String, Integer>();
		ratingsMapByMovie.put("mv1", 8);
		ratingsMapByMovie.put("mv2", 9);
		ratingsMapByMovie.put("mv3", 7);
	}
	
	private static Map<String, UserRating> ratingsMapByUser;

	static {
		ratingsMapByUser = new HashMap<String, UserRating>();
		ratingsMapByUser.put("u1", new UserRating(Arrays.asList(new Rating("mv1", 8), new Rating("mv3", 7))));
		ratingsMapByUser.put("u2", new UserRating(Arrays.asList(new Rating("mv1", 3), new Rating("mv2", 6))));
	}

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable(name = "movieId") String id) {
		return new Rating(id, ratingsMapByMovie.get(id));
	}

	@RequestMapping("/users/{userId}")
	public UserRating getRatingByUser(@PathVariable(name = "userId") String id) {
		logger.info("getRatingByUser Invoked");
		return ratingsMapByUser.get(id);
	}

}
