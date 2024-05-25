package com.ssafy.ssaccer.model.dao;

import java.util.List;

import com.ssafy.ssaccer.model.dto.MatchBoard;

public interface MatchBoardDao {
	// 생성
	public int insertBoard(MatchBoard matchBoard);
	
	// 조회
	public List<MatchBoard> selectByTeamId(int id); // 팀 아이디로 조회
	public MatchBoard selectOne(int id); // 게시판 아이디로 조회
	
	// 수정
	public int updateBoard(MatchBoard matchBoard);
	
	// 삭제
	public int deleteBoard(int id);
}
