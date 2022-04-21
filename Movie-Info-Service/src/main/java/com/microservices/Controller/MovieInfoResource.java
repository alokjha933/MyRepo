package com.microservices.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.MovieInfo;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@RequestMapping("/{movieId}")
	public MovieInfo getMovieById(@PathVariable String movieId) {
		return new MovieInfo(movieId, "Dhoom");
	}
}
