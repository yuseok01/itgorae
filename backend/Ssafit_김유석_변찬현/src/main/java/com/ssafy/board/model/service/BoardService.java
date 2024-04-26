package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.videoBoard;
import com.ssafy.board.model.dto.reviews;

public interface BoardService {
	//게시글 전체 조회
	public List<videoBoard> getBoardList();
	//게시글 상세조회
	public videoBoard readBoard(int videoNo); //Dao -> 뷰카운트 +1 / 게시글 조회 
	//게시글 작성
	public void writeBoard(videoBoard board);
	///게시글 삭제
	public void removeBoard(int id);
	//게시글 수정
	public void modifyBoard(videoBoard board);
	//게시글 검색

}
