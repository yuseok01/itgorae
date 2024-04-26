package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.ReviewsDao;
import com.ssafy.board.model.dto.reviews;

public class reviewsServiceImpl implements reviewsService  {
	
	private final ReviewsDao reviewDao;
	
	@Autowired
	public reviewsServiceImpl(ReviewsDao reviewDao) {
		this.reviewDao = reviewDao;
	} //의존성 주입 
	
	
	@Override
	public List<reviews> getReviews() {
		return reviewDao.selectAll();
	}

	@Transactional //database 수정 
	@Override
	public void writeReview(reviews review) {
		System.out.println("게시글을 작성합니다.");
		reviewDao.insertReviews(review);
	}
	@Transactional //database 수정 
	@Override
	public void removeReview(reviews review) {
		System.out.println( review.reviewSeq + "번 리뷰를 삭제합니다.");
		reviewDao.deleteReview(review);
	}
	@Transactional
	@Override
	public void modifyReview(reviews review) {
		System.out.println("게시글 수정");
		reviewDao.updateReview(review);
		
	}

}
