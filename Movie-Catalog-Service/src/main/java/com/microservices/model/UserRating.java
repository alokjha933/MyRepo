package com.microservices.model;

import java.util.List;

public class UserRating {
	private List<MovieRating> movieRating;

	public List<MovieRating> getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(List<MovieRating> movieRating) {
		this.movieRating = movieRating;
	}

}
