package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardService {
	//게시글 전체 조회
	public List<Board> getBoardList();
	//게시글 상세조회
	public Board readBoard(int id); //Dao -> 뷰카운트 +1 / 게시글 조회 
	//게시글 작성
	public void writeBoard(Board board);
	///게시글 삭제
	public void removeBoard(int id);
	//게시글 수정
	public void modifyBoard(Board board);
	//게시글 검색
	public List<Board> search(SearchCondition searchCondition);
}
