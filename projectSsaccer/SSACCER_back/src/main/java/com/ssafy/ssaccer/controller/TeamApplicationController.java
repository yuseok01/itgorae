package com.ssafy.ssaccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.dto.TeamApplication;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;
import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.service.TeamApplicationService;
import com.ssafy.ssaccer.model.service.TeamRecruitmentBoardService;
import com.ssafy.ssaccer.model.service.TeamService;
import com.ssafy.ssaccer.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/application")
@Tag(name = "TeamApplicationController", description = "가입 신청")
public class TeamApplicationController {
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final TeamApplicationService teamApplicationService;
	private final UserService userService;
	private final TeamService teamService;
	private final TeamRecruitmentBoardService boardService;

	@Autowired
	public TeamApplicationController(TeamApplicationService teamApplicationService, UserService userService,
			TeamService teamService, TeamRecruitmentBoardService boardService) {
		this.teamApplicationService = teamApplicationService;
		this.userService = userService;
		this.teamService = teamService;
		this.boardService = boardService;
	}

	// 가입 신청
	@PostMapping("/{recruitmentBoardId}")
	public ResponseEntity<?> apply(@PathVariable("recruitmentBoardId") int boardId,
			@RequestBody TeamApplication teamApplication) {
		TeamRecruitmentBoard board = boardService.readBoard(boardId);
		int teamId = board.getTeamId(); // 게시글 올린 팀

		teamApplication.setRecruitmentBoardId(boardId);
		teamApplication.setTeamId(teamId);

		System.out.println(teamApplication);
		teamApplicationService.writeApplication(teamApplication);
		return new ResponseEntity<TeamApplication>(teamApplication, HttpStatus.OK);
	}

	// 팀에서 조회
	@GetMapping("/team/{id}")
	public ResponseEntity<?> searchByTeam(@PathVariable("id") int teamId) {
		List<TeamApplication> list = teamApplicationService.searchByTeamId(teamId);

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		for (TeamApplication application : list) {
			int userId = application.getUserId();
			User user = userService.getUserById(userId);
			application.setUserName(user.getUserName());
			application.setNickName(user.getNickName());
			application.setPosition(user.getPosition());

			int userTeamId = user.getTeamId();
			Team userTeam = teamService.searchByTeamId(userTeamId);
			application.setUserTeamId(userTeamId);
			application.setUserTeamName(userTeam.getTeamName());
			System.out.println(application);
		}
		return new ResponseEntity<List<TeamApplication>>(list, HttpStatus.OK);
	}

	// 아이디로 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> searchById(@PathVariable("id") int id) {
		TeamApplication teamApplication = teamApplicationService.searchById(id);

		if (teamApplication != null) {
			return new ResponseEntity<TeamApplication>(teamApplication, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 신청 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (teamApplicationService.removeApplication(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 팀에서 수락
	@PutMapping("/accept/{id}")
	public ResponseEntity<?> accept(@PathVariable("id") int id) {
		TeamApplication teamApplication = teamApplicationService.searchById(id);
		
		// 선수 정보 수정
		int userId = teamApplication.getUserId();
		User user = userService.getUserById(userId);

		int teamId = teamApplication.getTeamId();
		user.setTeamId(teamId);
		user.setUserRank(3); // 선수 계급

//		System.out.println(user);
		if (userService.modifyUser(user)) {
//			teamApplicationService.removeApplication(id);
			teamApplicationService.acceptApplication(id);
			teamApplication = teamApplicationService.searchById(id);
			return new ResponseEntity<TeamApplication>(teamApplication, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	// 거절
	@PutMapping("/reject/{id}")
	public ResponseEntity<?> reject(@PathVariable("id") int id) {
		teamApplicationService.rejectApplication(id);
		TeamApplication teamApplication = teamApplicationService.searchById(id);
		return new ResponseEntity<TeamApplication>(teamApplication, HttpStatus.OK);
	}
}
