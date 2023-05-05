package cse.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse.data.pojo.ReviewTemplate;
import cse.data.pojo.User;
import cse.data.repo.ReviewRepo;
import cse.data.repo.pojo.Review;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo repo;
	
	public Review getReview(UUID id) {
		return repo.findById(id).get();
	}
	/**
	 * Get all reviews for a user.
	 */
	public List<Review> getReviews(User user) {
		return repo.findByUserId(user.getUuid());
	}
	
	public List<Review> getReviewsByTrail(UUID trailID) {
		return repo.findByTrailId(trailID);
	}
	
	public void addReview(User user, ReviewTemplate review) {
		repo.saveAndFlush(new Review(user, review));
	}
}
