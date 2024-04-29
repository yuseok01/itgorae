package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewDao {

	List<Review> selectReviewsByVideo(int videoId);

	Review selectReview(int videoId, int reviewId);

	void insertReview(int videoId, Review review);
	
	void updateReview(int videoId, int reviewId, String content);

	void deleteReview(int videoId, int reviewId);
	
	void updateReviewViewcnt(int videoId, int reviewId);

//	void createVideoReviewsRepo(int videoId);
}
