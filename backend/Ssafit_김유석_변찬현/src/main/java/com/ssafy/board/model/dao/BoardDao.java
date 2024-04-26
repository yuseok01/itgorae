package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.videoBoard;
import com.ssafy.board.model.dto.reviews;

public interface BoardDao {
	// 전체 게시글을 조회
	public List<videoBoard> selectAll();

	// ID에 해당하는 게시글 하나 가져오기
	public videoBoard selectOne(int id);

	// 게시글 등록
	public void insertBoard(videoBoard board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(videoBoard board);

	// 조회수 증가
	public void updateViewCnt(int id);
	
	// 검색 기능
	public List<videoBoard> search(reviews searchCondition);

}
