package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.board.model.dao.VideoDao;
import com.ssafit.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	private final VideoDao videoDao;
	
	
	@Autowired
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public List<Video> getVideoList() {
		return videoDao.selectAll(); //비디오 목록 줘 
	}

	@Override //비디오 상세조회 videono로 
	public Video readVideo(int no) {
		return videoDao.selectOne(no);
	}
	
	
}
