package com.ssafy.ssaccer.model.dao;

import java.util.List;

import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;

public interface TeamRecruitmentBoardDao {
	// 게시글 전체 조회 및 검색 기능
	public List<TeamRecruitmentBoard> search(SearchCondition searchCondition);

	// 게시글 상세 조회
	public TeamRecruitmentBoard selectOne(int id);

	// 게시글 등록
	public int insertBoard(TeamRecruitmentBoard board);

	// 게시글 삭제
	public int deleteBoard(int id);

	// 게시글 수정
	public int updateBoard(TeamRecruitmentBoard board);

	// 조회수 증가
//	public void updateViewCnt(int id);
}
