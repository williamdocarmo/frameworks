package com.movie.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.moviecatalogservice.model.CatalogItem;
import com.movie.moviecatalogservice.model.Movie;
import com.movie.moviecatalogservice.model.Rating;
import com.movie.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	private static final Logger logger = LoggerFactory.getLogger(MovieCatalogResource.class);

	@RequestMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
		
		discoveryClient();
		
		// API Call to Ratings Service
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratings/users/"+userId, UserRating.class);

		List<CatalogItem> items = new ArrayList<CatalogItem>();
		for (Rating r : ratings.getUserRatings()) {
			// API Call to Movies Service
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + r.getMovieId(), Movie.class);
			items.add(new CatalogItem(movie.getMovieName(), null, r.getRating()));
		}
		return items;
	}

	private void discoveryClient() {
		List<String> services = discoveryClient.getServices();
		logger.info("Service List: "+services);
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("movie-info-service");
		logger.info("Service Instances: "+serviceInstances);
	}

}

/**
Movie movie = webClientBuilder.build().get().
		uri("http://localhost:4402/movies/" + r.getMovieId()).
		retrieve().bodyToMono(Movie.class).block();
*/