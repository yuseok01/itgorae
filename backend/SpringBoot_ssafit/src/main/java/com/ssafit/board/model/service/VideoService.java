package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Video;

public interface VideoService {
	/*1. 비디오 전체 조회
	 * 2. 비디오 상세 조회
	 * 3. 비디오 추가 
	 * 
	 */

	
	public List<Video> getVideoList();//비디오 전체조회
	
	
	public Video readVideo(int id); //비디오 상세 조회 
	
	
	}
