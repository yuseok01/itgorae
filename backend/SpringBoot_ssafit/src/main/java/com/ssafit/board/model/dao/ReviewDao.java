package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewDao {
	public List<Review> selectAll();
	
	public Review selectOne(int id);
	
	public int insertReview(Review review);
	
	public int updateReview(Review review);
	
	public int deleteReview(int id);
}
