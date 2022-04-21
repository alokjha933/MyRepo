package com.microservices.model;

public class MovieRating {

	private String movieId;
	private String rating;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public MovieRating(String movieId, String rating) {
		this.movieId = movieId;
		this.rating = rating;
	}

}
