package cse.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cse.data.pojo.ReviewTemplate;
import cse.data.pojo.User;
import cse.data.repo.pojo.Review;
import cse.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/user")
	public List<Review> getReviews(JwtAuthenticationToken token) {
		final User user = User.getUserFromToken(token);
		
		return reviewService.getReviews(user);
	}
	
	@GetMapping("/trail/{trailID}")
	public List<Review> getReviews(@PathVariable UUID trailID) {
		return reviewService.getReviewsByTrail(trailID);
	}
	
	@GetMapping("/id/{reviewID}")
	public Review getReview(@PathVariable UUID reviewID) {
		return reviewService.getReview(reviewID);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postReview(JwtAuthenticationToken token, 
			@RequestBody ReviewTemplate template) {
		
		final User user = User.getUserFromToken(token);
		
		reviewService.addReview(user, template);
	}
}
