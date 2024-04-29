package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	// 전체 목록 조회
	List<Video> getVideoList();
	
	// 부위별 목록 조회
	List<Video> getVideoListByPart(String part);
	
	// 정렬 조회
	List<Video> getOrderByViewCnt();
	
	// 상세 조회
	Video getVideoById(int videoId);
	
	// 상세 리뷰 조회
	List<Review> getReviewById(int videoId);
}
