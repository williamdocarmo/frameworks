package com.movie.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.movie.moviecatalogservice.model.MovieSummary;
import com.movie.moviecatalogservice.model.Rating;
import com.movie.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

// @RestController
// @RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	private static final Logger logger = LoggerFactory.getLogger(MovieCatalogResource.class);

	@RequestMapping(value = "/{userId}")
	@HystrixCommand(fallbackMethod = "getCatalogFallback")
	public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratings/users/"+userId, UserRating.class);

		List<CatalogItem> items = new ArrayList<CatalogItem>();
		for (Rating r : ratings.getUserRatings()) {
			MovieSummary movie = restTemplate.getForObject("http://movie-info-service/movies/" + r.getMovieId(), MovieSummary.class);
			items.add(new CatalogItem(movie.getTitle(), movie.getOverview(), r.getRating()));
		}
		return items;
	}
	
	public List<CatalogItem> getCatalogFallback(@PathVariable(name = "userId") String userId) {
		logger.info("Fallback Executed: "+userId);
		return Arrays.asList(new CatalogItem("Movie Data Not Found", "", -1));
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