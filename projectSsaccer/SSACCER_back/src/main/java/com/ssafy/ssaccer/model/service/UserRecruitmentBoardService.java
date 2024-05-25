package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.UserRecruitmentBoard;

public interface UserRecruitmentBoardService {
	// 게시글 전체 조회 및 삭제
	public List<UserRecruitmentBoard> searchBoard(SearchCondition searchCondition);

	// 게시글 상세조회
	public UserRecruitmentBoard readBoard(int id);

	// 게시글 작성
	public boolean writeBoard(UserRecruitmentBoard board);

	/// 게시글 삭제
	public boolean removeBoard(int id);

	// 게시글 수정
	public boolean modifyBoard(UserRecruitmentBoard board);
}
