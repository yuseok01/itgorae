package com.ssafy.ssaccer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.UserRecruitmentBoardDao;
import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.UserRecruitmentBoard;

@Service
public class UserRecruitmentBoardServiceImpl implements UserRecruitmentBoardService {
	private final UserRecruitmentBoardDao boardDao;

	@Autowired
	public UserRecruitmentBoardServiceImpl(UserRecruitmentBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<UserRecruitmentBoard> searchBoard(SearchCondition searchCondition) {
		return boardDao.search(searchCondition);
	}

	@Override
	public UserRecruitmentBoard readBoard(int id) {
		// boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public boolean writeBoard(UserRecruitmentBoard board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int id) {
		return boardDao.deleteBoard(id) == 1;
	}

	@Override
	public boolean modifyBoard(UserRecruitmentBoard board) {
		return boardDao.updateBoard(board) == 1;
	}
}
