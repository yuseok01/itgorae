package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	
	List<Review> getReviewsByVideo(int videoId);

	Review getReview(int videoId, int reviewId);

	void writeReview(int videoId, Review review);

	void modifyReview(int videoId, int reviewId, String content);

	void removeReview(int videoId, int reviewId);

}
