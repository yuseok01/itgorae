package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewService {
	public List<Review> getReviewList(); //전체 리뷰 조회
	
	public int insertReview(Review review);//리뷰 적기
	
	public int modifyReview(Review review);//리뷰 수정
	
	public int removeReivew(int id);//리뷰 제거 
}
