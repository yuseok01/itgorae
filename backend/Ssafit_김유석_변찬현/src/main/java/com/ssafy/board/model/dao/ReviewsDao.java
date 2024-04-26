package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.reviews;

public interface ReviewsDao {
	//전체 리뷰 조회
	public List<reviews> selectAll();
	
	//리뷰 작성
	public void insertReviews(reviews review);
	
	//리뷰 삭제
	public void deleteReview(reviews review);
	
	//리뷰 수정
	public void updateReview(reviews review);
}
