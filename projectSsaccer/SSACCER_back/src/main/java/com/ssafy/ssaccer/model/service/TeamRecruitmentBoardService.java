package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;

public interface TeamRecruitmentBoardService {
	// 게시글 전체 조회 및 삭제
	public List<TeamRecruitmentBoard> searchBoard(SearchCondition searchCondition);

	// 게시글 상세조회
	public TeamRecruitmentBoard readBoard(int id);

	// 게시글 작성
	public boolean writeBoard(TeamRecruitmentBoard board);

	/// 게시글 삭제
	public boolean removeBoard(int id);

	// 게시글 수정
	public boolean modifyBoard(TeamRecruitmentBoard board);
}
