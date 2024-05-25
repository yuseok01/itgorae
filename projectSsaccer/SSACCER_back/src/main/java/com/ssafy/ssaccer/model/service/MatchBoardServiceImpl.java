package com.ssafy.ssaccer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.MatchBoardDao;
import com.ssafy.ssaccer.model.dto.MatchBoard;

@Service
public class MatchBoardServiceImpl implements MatchBoardService {
	private final MatchBoardDao boardDao;
	
	@Autowired
	public MatchBoardServiceImpl(MatchBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public int createBoard(MatchBoard matchBoard) {
		return boardDao.insertBoard(matchBoard);
	}

	@Override
	public List<MatchBoard> readByTeamId(int id) {
		return boardDao.selectByTeamId(id);
	}

	@Override
	public MatchBoard readOne(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public boolean updateBoard(MatchBoard matchBoard) {
		return boardDao.updateBoard(matchBoard) == 1;
	}

	@Override
	public boolean deleteBoard(int id) {
		return boardDao.deleteBoard(id) == 1;
	}

}
