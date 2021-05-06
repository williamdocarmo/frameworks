package com.movie.moviecatalogservice.model;

import java.util.List;

public class UserRating {
	
	private List<Rating> userRatings;

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserRating [userRatings=" + userRatings + "]";
	}

}
