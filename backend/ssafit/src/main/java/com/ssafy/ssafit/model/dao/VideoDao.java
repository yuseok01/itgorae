package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	// 전체 목록 조회
	public List<Video> selectVideoList();
	
	// 부위별 목록 조회
	public List<Video> selectVideoByPart(String part);
	
	// 정렬 조회
	public List<Video> selectOrderByViewCnt();
	
	// 상세 조회
	public Video selectVideoById(int videoId);
	
	// 상세 리뷰 조회
	public List<Review> selectVideoReviewById(int videoId);
}
