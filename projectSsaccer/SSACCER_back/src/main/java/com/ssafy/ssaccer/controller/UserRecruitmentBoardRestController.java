package com.ssafy.ssaccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.UserRecruitmentBoard;
import com.ssafy.ssaccer.model.service.UserRecruitmentBoardService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/userRecruitment")
@Tag(name = "UserRecruitmentRestController", description = "선수가 팀을 구하는 게시판")
public class UserRecruitmentBoardRestController {
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final UserRecruitmentBoardService boardService;

	@Autowired
	public UserRecruitmentBoardRestController(UserRecruitmentBoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 (검색) 조회
	@GetMapping("/board")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		List<UserRecruitmentBoard> list = boardService.searchBoard(condition); // 검색 조회
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<UserRecruitmentBoard>>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<UserRecruitmentBoard> detail(@PathVariable("id") int id) {
		UserRecruitmentBoard board = boardService.readBoard(id);
		if (board != null)
			return new ResponseEntity<UserRecruitmentBoard>(board, HttpStatus.OK);
		return new ResponseEntity<UserRecruitmentBoard>(HttpStatus.NOT_FOUND);
	}

	// 게시글 등록
	@PostMapping("/board")
	public ResponseEntity<?> write(@RequestBody UserRecruitmentBoard board) {
		boardService.writeBoard(board);
		return new ResponseEntity<UserRecruitmentBoard>(board, HttpStatus.CREATED);
	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		if (boardService.removeBoard(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/board")
	public ResponseEntity<String> update(@RequestBody UserRecruitmentBoard board) {
		if (boardService.modifyBoard(board))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
}
