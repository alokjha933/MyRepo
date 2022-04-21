package com.microservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.MovieRating;
import com.microservices.model.UserRating;

@RestController
@RequestMapping("/rating")
public class MovieRatingResource {

	@RequestMapping("/{movieId}")
	public MovieRating getRatingById(@PathVariable String movieId) {
		return new MovieRating(movieId, "*****");
	}

	@RequestMapping("user/{userId}")
	public UserRating getRatingByUserId(@PathVariable String userId) {
		List<MovieRating> ratingList = Arrays.asList(new MovieRating("121", "A1"), new MovieRating("122", "A11"));
		UserRating userRating = new UserRating();
		userRating.setMovieRating(ratingList);
		return userRating;
	}
}
