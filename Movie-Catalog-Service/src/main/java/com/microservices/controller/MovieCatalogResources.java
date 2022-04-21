package com.microservices.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservices.model.CatalogItem;
import com.microservices.model.MovieInfo;
import com.microservices.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

	@Autowired
	RestTemplate restTemplate;

	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */
	/*
	 * @Autowired WebClient.Builder webClientBuilder;
	 */

	@RequestMapping("/{userId}")
	List<CatalogItem> movieCatalog(@PathVariable("userId") String userId) {
		UserRating userRating = restTemplate.getForObject("http://movie-rating-service/rating/user/123",
				UserRating.class);

		return userRating.getMovieRating().stream().map(rating -> {

			MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					MovieInfo.class);

			/*
			 * MovieInfo movieInfo = webClientBuilder.build().get()
			 * .uri("http://localhost:8082/movies/" +
			 * rating.getMovieId()).retrieve().bodyToMono(MovieInfo.class) .block();
			 */

			return new CatalogItem(movieInfo.getMovieName(), "Desc", rating.getRating());
		}).collect(Collectors.toList());
	}

}
