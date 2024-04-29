package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	private final VideoDao videoDao;
	
	@Autowired
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public List<Video> getVideoList() {
		return videoDao.selectVideoList();
	}

	@Override
	public List<Video> getVideoListByPart(String part) {
		return videoDao.selectVideoByPart(part);
	}

	@Override
	public List<Video> getOrderByViewCnt() {
		return videoDao.selectOrderByViewCnt();
	}

	@Override
	public Video getVideoById(int videoId) {
		return videoDao.selectVideoById(videoId);
	}

	@Override
	public List<Review> getReviewById(int videoId) {
		return videoDao.selectVideoReviewById(videoId);
	}
	
	

}
