package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Video;

public interface VideoDao {
	//전체 게시글을 조회
	public List<Video> selectAll();
	
	//id에 해당하는 게시글 하나 가져오기
	public Video selectOne(int id);
}
