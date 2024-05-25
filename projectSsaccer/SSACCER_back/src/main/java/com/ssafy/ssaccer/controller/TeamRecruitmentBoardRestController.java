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
import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;
import com.ssafy.ssaccer.model.service.TeamRecruitmentBoardService;
import com.ssafy.ssaccer.model.service.TeamService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/posts")
@Tag(name = "TeamRecruitmentRestController", description = "팀에서 모집하는 게시판")
public class TeamRecruitmentBoardRestController {
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final TeamRecruitmentBoardService boardService;
	private final TeamService teamService;

	@Autowired
	public TeamRecruitmentBoardRestController(TeamRecruitmentBoardService boardService, TeamService teamService) {
		this.boardService = boardService;
		this.teamService = teamService;
	}

	// 게시글 (검색) 조회
	@GetMapping()
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		List<TeamRecruitmentBoard> list = boardService.searchBoard(condition); // 검색 조회

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		for (TeamRecruitmentBoard board : list) {
			int teamId = board.getTeamId();
			Team team = teamService.searchByTeamId(teamId);
			String teamName = team.getTeamName();
			String teamImg = team.getTeamImg();
			board.setTeamName(teamName);
			board.setTeamImg(teamImg);
		}
		System.out.println(condition);
		System.out.println(list);
		return new ResponseEntity<List<TeamRecruitmentBoard>>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/{id}")
	public ResponseEntity<TeamRecruitmentBoard> detail(@PathVariable("id") int id) {
		TeamRecruitmentBoard board = boardService.readBoard(id);
		if (board != null)
			return new ResponseEntity<TeamRecruitmentBoard>(board, HttpStatus.OK);
		return new ResponseEntity<TeamRecruitmentBoard>(HttpStatus.NOT_FOUND);
	}

	// 게시글 등록
	@PostMapping("/board")
	public ResponseEntity<?> write(@RequestBody TeamRecruitmentBoard board) {
		boardService.writeBoard(board);
		return new ResponseEntity<TeamRecruitmentBoard>(board, HttpStatus.CREATED);
	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		if (boardService.removeBoard(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 게시글 수정
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody TeamRecruitmentBoard board) {
//		TeamRecruitmentBoard teamRecruitmentBoard = boardService.readBoard(id);
		board.setId(id);
		if (boardService.modifyBoard(board)) {
			System.out.println(board);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
}
