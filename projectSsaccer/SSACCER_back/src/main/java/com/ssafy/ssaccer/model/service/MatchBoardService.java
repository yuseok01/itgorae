package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.MatchBoard;

public interface MatchBoardService {
	// 생성
	public int createBoard(MatchBoard matchBoard);
	
	// 조회
	public List<MatchBoard> readByTeamId(int id); // 팀 아이디로 조회
	public MatchBoard readOne(int id); // 게시판 아이디로 조회
	
	// 수정
	public boolean updateBoard(MatchBoard matchBoard);
	
	// 삭제
	public boolean deleteBoard(int id);
}
