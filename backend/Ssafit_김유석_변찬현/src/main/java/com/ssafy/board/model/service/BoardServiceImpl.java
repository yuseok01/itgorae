package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.videoBoard;
import com.ssafy.board.model.dto.reviews;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<videoBoard> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public videoBoard readBoard(int id) {
		System.out.println(id + "번 게시글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional //database 수정 
	@Override
	public void writeBoard(videoBoard board) {
//		board.setId(1000);
		System.out.println("게시글 작성합니다.");
		boardDao.insertBoard(board);
//		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println(id+"번 게시글을 삭제하겠습니다.");
		boardDao.deleteBoard(id);
	}

	@Transactional
	@Override
	public void modifyBoard(videoBoard board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}


}
