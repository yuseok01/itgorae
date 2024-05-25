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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssaccer.model.dto.MatchRequest;
import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.service.MatchRequestService;
import com.ssafy.ssaccer.model.service.TeamService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/matchRequest")
@Tag(name = "MatchRequestRestController", description = "매치신청 CRUD")
public class MatchRequestRestController {
	private static final String SUCCESS = "Success";
	private static final String FAIL = "Fail";

	private final MatchRequestService matchRequestService;
	private final TeamService teamService;

	@Autowired
	public MatchRequestRestController(MatchRequestService matchRequestService, TeamService teamService) {
		super();
		this.matchRequestService = matchRequestService;
		this.teamService = teamService;
	}

	// 매치 신청
	@PostMapping()
	public ResponseEntity<?> request(@RequestBody MatchRequest matchRequest) {
		MatchRequest search = matchRequestService.searchRequest(matchRequest);
		System.out.println(matchRequest + " --------------------");
		if (search != null) {
			System.out.println("이미 존재합니다");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		int teamIdFrom = matchRequest.getTeamIdFrom();
		int teamIdTo = matchRequest.getTeamIdTo();
		if (teamIdFrom == teamIdTo) {
			System.out.println("내 팀에는 신청할 수 없습니다.");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		Team from = teamService.searchByTeamId(teamIdFrom);
		Team to = teamService.searchByTeamId(teamIdTo);
		matchRequest.setTeamNameFrom(from.getTeamName());
		matchRequest.setTeamNameTo(to.getTeamName());
		if (matchRequestService.makeRequest(matchRequest)) {
			System.out.println(matchRequest);
			return new ResponseEntity<MatchRequest>(matchRequest, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	// 매치 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> search(@PathVariable("id") int teamId) {
		List<MatchRequest> list = matchRequestService.searchRequestById(teamId);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		for (MatchRequest match : list) {
			int teamIdFrom = match.getTeamIdFrom();
			int teamIdTo = match.getTeamIdTo();
			Team from = teamService.searchByTeamId(teamIdFrom);
			Team to = teamService.searchByTeamId(teamIdTo);
			match.setTeamNameFrom(from.getTeamName());
			match.setTeamNameTo(to.getTeamName());
			match.setPoints(from.getPoints());
			match.setGoals(from.getGoals());
			match.setAssists(from.getAssists());
			match.setConceded(from.getConceded());
			match.setWon(from.getWon());
			match.setDrawn(from.getDrawn());
			match.setLost(from.getLost());
			match.setPlayed(from.getPlayed());
			match.setRegion(from.getRegion());
			match.setHomeStadium(from.getHomeStadium());
		}
		System.out.println(list);
		return new ResponseEntity<List<MatchRequest>>(list, HttpStatus.OK);
	}

	// 매치 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int matchRequestid) {
		if (matchRequestService.removeRequest(matchRequestid))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 매치 조회
	@GetMapping()
	public ResponseEntity<?> searchMatch(@ModelAttribute MatchRequest matchRequest) {
		System.out.println(matchRequest);
		MatchRequest res = matchRequestService.searchRequest(matchRequest);
		System.out.println(res);
		if (res != null) {
			return new ResponseEntity<MatchRequest>(res, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
