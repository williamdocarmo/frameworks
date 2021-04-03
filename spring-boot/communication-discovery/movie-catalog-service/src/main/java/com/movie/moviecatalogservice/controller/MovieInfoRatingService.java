package com.movie.moviecatalogservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.moviecatalogservice.model.MovieSummary;
import com.movie.moviecatalogservice.model.Rating;
import com.movie.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoRatingService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getCatalogItemFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10") })
	public MovieSummary getCatalogItem(String movieId) {
		return restTemplate.getForObject("http://movie-info-service/movies/" + movieId, MovieSummary.class);
	}

	@HystrixCommand(fallbackMethod = "getUserRatingFallback", threadPoolKey = "ratingPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10") })
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://rating-data-service/ratings/users/" + userId, UserRating.class);
	}

	public MovieSummary getCatalogItemFallback(String movieId) {
		MovieSummary movieSummary = new MovieSummary();
		movieSummary.setId(-1);
		movieSummary.setTitle("Title Not Found");
		movieSummary.setOverview("Overview not Found");
		return movieSummary;
	}

	public UserRating getUserRatingFallback(String userId) {
		return new UserRating(Arrays.asList(new Rating("0", -1)));
	}

}
