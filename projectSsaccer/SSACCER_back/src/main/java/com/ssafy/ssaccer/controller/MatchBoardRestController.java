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

import com.ssafy.ssaccer.model.dto.MatchBoard;
import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;
import com.ssafy.ssaccer.model.service.MatchBoardService;
import com.ssafy.ssaccer.model.service.TeamService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/matchBoards")
@Tag(name = "MatchBoardRestController", description = "경기 내용 게시판")
public class MatchBoardRestController {
	private final MatchBoardService matchBoardService;
	private final TeamService teamService;

	@Autowired
	public MatchBoardRestController(MatchBoardService matchBoardService, TeamService teamService) {
		super();
		this.matchBoardService = matchBoardService;
		this.teamService = teamService;
	}

	// 게시글 생성
	@PostMapping()
	public ResponseEntity<?> write(@RequestBody MatchBoard board) {
		StringBuilder sb = new StringBuilder();
		matchBoardService.createBoard(board);
		sb.append(board.toString() + '\n');
		// 상대팀 보드도 동시에 생성
		int myTeamId = board.getMyTeamId();
		int opposingTeamId = board.getOpposingTeamId();
		board.setMyTeamId(opposingTeamId);
		board.setOpposingTeamId(myTeamId);
		matchBoardService.createBoard(board); // 상대팀 보드
		sb.append(board.toString());
		return new ResponseEntity<String>(sb.toString(), HttpStatus.CREATED);
	}

	// 팀 아이디로 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> list(@PathVariable("id") int teamId) {
		List<MatchBoard> list = matchBoardService.readByTeamId(teamId); // 검색 조회

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		// 최신 순으로 정렬
		list.sort((t1, t2) -> t2.getCreateAt().compareTo(t1.getCreateAt()));
		for (MatchBoard board : list) {
			int myTeamId = board.getMyTeamId();
			int opposingTeamId = board.getOpposingTeamId();
			Team myTeam = teamService.searchByTeamId(myTeamId);
			Team opposingTeam = teamService.searchByTeamId(opposingTeamId);
			board.setMyTeamName(myTeam.getTeamName());
			board.setOpposingTeamName(opposingTeam.getTeamName());
		}
		System.out.println(list);
		return new ResponseEntity<List<MatchBoard>>(list, HttpStatus.OK);
	}

	@GetMapping("/matchBoard/{id}")
	public ResponseEntity<?> selectOne(@PathVariable("id") int boardId) {
		MatchBoard matchBoard = matchBoardService.readOne(boardId);
		if (matchBoard != null)
			return new ResponseEntity<MatchBoard>(matchBoard, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int boardId, @RequestBody MatchBoard matchBoard) {
		matchBoard.setBoardId(boardId);
		if (matchBoardService.updateBoard(matchBoard)) {
			System.out.println(matchBoard);
			return new ResponseEntity<MatchBoard>(matchBoard, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	// 삭제 보류
	// 게시글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		if (matchBoardService.deleteBoard(id))
			return new ResponseEntity<Void>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
