package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dto.Review;

public class ReviewServiceImpl implements ReviewService {

	private final ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	
	@Override
	public List<Review> getReviewList() {
		
		return reviewDao.selectAll();
	}

	@Override
	public int insertReview(Review review) {
	
		return reviewDao.insertReview(review);
	}

	@Override
	public int modifyReview(Review review) {
		
		return reviewDao.updateReview(review);
	}

	@Override
	public int removeReivew(int id) {
		// TODO Auto-generated method stub
		return reviewDao.deleteReview(id);
	}

}
