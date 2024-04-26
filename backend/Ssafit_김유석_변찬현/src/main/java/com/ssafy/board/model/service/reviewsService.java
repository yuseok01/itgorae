package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.reviews;

public interface reviewsService{
	//videoNum을 key로 getReviews 하자
	public List<reviews> getReviews();
	
	//리뷰한다.
	public void writeReview(reviews review);
	
	//userId를 key로 Reviews를 제거해보자 
	public void removeReview(reviews review);
	
	//reviewsNum을 key로 reviews를 수정해보자
	public void modifyReview(reviews review);
	
}
