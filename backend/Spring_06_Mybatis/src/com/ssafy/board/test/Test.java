package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){//true면 알아서 저장해줌 
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for(Board board : boards) {
				System.out.println(board); //전체 보드 출력
			}//namelist를 쭉 적어서 귀찮은 방식 
		}
		
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
//			session.selectOne(null) 해당 라인의 selectOne과 아래의 selectOne 출처가 다르다.
 			Board board = dao.selectOne(1);
			System.out.println(board);
			//인터페이스를 활용해서 편리한 방식 getmapper 사용 
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = new Board("아괜", "양띵균", "아직은 괜찮아~");
			dao.insertBoard(board);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.deleteBoard(2); //2번글 지우자 
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.updateViewCnt(3); //조회수 증가 
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			board.setContent("열심히 해야한다");
			dao.updateBoard(board);
		}
		
	}
}
