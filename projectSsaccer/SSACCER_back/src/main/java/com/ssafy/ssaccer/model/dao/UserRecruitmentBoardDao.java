package com.ssafy.ssaccer.model.dao;

import java.util.List;

import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.UserRecruitmentBoard;

public interface UserRecruitmentBoardDao {

    // 게시글 전체 조회 및 검색 기능
    public List<UserRecruitmentBoard> search(SearchCondition searchCondition);

    // 게시글 상세 조회
    public UserRecruitmentBoard selectOne(int id);

    // 게시글 등록
    public int insertBoard(UserRecruitmentBoard board);

    // 게시글 삭제
    public int deleteBoard(int id);

    // 게시글 수정
    public int updateBoard(UserRecruitmentBoard board);
}
