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

	private static Map<String, UserRating> ratingsMapByUser;

	static {
		ratingsMapByUser = new HashMap<String, UserRating>();
		ratingsMapByUser.put("u1", new UserRating(Arrays.asList(new Rating("550", 8), new Rating("552", 7), new Rating("554", 6))));
		ratingsMapByUser.put("u2", new UserRating(Arrays.asList(new Rating("551", 3), new Rating("555", 6), new Rating("553", 3))));
	}

	@RequestMapping("/users/{userId}")
	public UserRating getRatingByUser(@PathVariable(name = "userId") String id) {
		logger.info("getRatingByUser Invoked");
		/**
		if (id.equals("u2")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		return ratingsMapByUser.get(id);
	}

}
