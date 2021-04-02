package com.movie.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviecatalogservice.model.CatalogItem;
import com.movie.moviecatalogservice.model.MovieSummary;
import com.movie.moviecatalogservice.model.Rating;
import com.movie.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResourceGranularFallback {
	
	@Autowired
	private MovieInfoRatingService granularResource;
	
	private static final Logger logger = LoggerFactory.getLogger(MovieCatalogResourceGranularFallback.class);

	@RequestMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
		
		UserRating ratings = granularResource.getUserRating(userId);

		List<CatalogItem> items = new ArrayList<CatalogItem>();
		for (Rating r : ratings.getUserRatings()) {
			MovieSummary movie = granularResource.getCatalogItem(r.getMovieId());
			logger.info("Retrieved Movie Summary: "+movie);
			items.add(new CatalogItem(movie.getTitle(), movie.getOverview(), r.getRating()));
		}
		return items;
	}
	
}