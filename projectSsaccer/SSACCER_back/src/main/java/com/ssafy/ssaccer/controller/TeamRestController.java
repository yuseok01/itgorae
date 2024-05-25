package com.ssafy.ssaccer.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.ssafy.ssaccer.model.service.TeamService;
import com.ssafy.ssaccer.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/team")
@Tag(name="TeamRestController", description = "전체팀조회, 팀상세조회, 팀생성")
public class TeamRestController {
	private final TeamService teamService;
	private final UserService userService;
	
	@Autowired
	public TeamRestController(TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
	}
	
	@GetMapping("/searchAll")
	@Operation(summary = "전체조회")
	public ResponseEntity<List<Team>> selectAll() {
		List<Team> list = teamService.getTeamList();
		System.out.println(list);
		return new ResponseEntity<List<Team>>(list, HttpStatus.ACCEPTED);
	}
	
	// order
	@GetMapping("/rankAll")
	public ResponseEntity<List<Team>> rankAll() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		list.sort((Team t1, Team t2) -> -Integer.compare(t1.getPoints(), t2.getPoints()));
		System.out.println(list);
		return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
	}
	// 서울 승점순
	@GetMapping("/rankSeoul")
	public ResponseEntity<List<Team>> rankSeoul() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("서울"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 경기 승점순
	@GetMapping("/rankGyeongi")
	public ResponseEntity<List<Team>> rankGyeongi() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("경기"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 대전 승점순
	@GetMapping("/rankDaejeon")
	public ResponseEntity<List<Team>> rankDaejeon() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("대전"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 대구 승점순
	@GetMapping("/rankDaegu")
	public ResponseEntity<List<Team>> rankDaegu() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("대구"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 광주 승점순
	@GetMapping("/rankGwangju")
	public ResponseEntity<List<Team>> rankGwangju() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("광주"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 부산 승점순
	@GetMapping("/rankBusan")
	public ResponseEntity<List<Team>> rankBusan() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("부산"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	// 울산 승점순
	@GetMapping("/rankUlsan")
	public ResponseEntity<List<Team>> rankUlsan() {
		List<Team> list = teamService.getTeamList();
		list.remove(0); // 팀 없음 제거
		
		List<Team> seoulList = list.stream().filter(team -> team.getRegion().equals("울산"))
				.sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<Team>>(seoulList, HttpStatus.OK);
	}
	
	@GetMapping("/search/{id}")
	@Operation(summary = "아이디조회")
	public ResponseEntity<Team> selectByNickName(@PathVariable("id") int teamId) {
		Team team = teamService.searchByTeamId(teamId);
		if (team != null) {
			return new ResponseEntity<>(team, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/create/{id}")
	@Operation(summary = "팀생성")
	public ResponseEntity<Team> createTeam(@PathVariable("id") int userId, @RequestBody String teamName) {
		// insert team
		teamService.createTeam(teamName);
		// user update team
		int lastId = teamService.getLastId();
		userService.userCreateTeam(userId, lastId);
		System.out.println(lastId);
		return new ResponseEntity<Team>(HttpStatus.CREATED);
	}
	
	@GetMapping("/lastId")
	@Operation(summary = "마지막 Id")
	public ResponseEntity<?> getLastId() {
		int lastId = teamService.getLastId();
		return new ResponseEntity<>(lastId, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "팀 수정")
	public ResponseEntity<?> updateTeam(@PathVariable("id") int teamId, @RequestBody Team team) {
		team.setId(teamId);
		System.out.println(team);
		if (teamService.modifyTeam(team))
			return new ResponseEntity<Team>(team, HttpStatus.ACCEPTED);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "팀 삭제")
	public ResponseEntity<?> delte(@PathVariable("id") int teamId) {
		userService.userRemovedTeam(teamId); // 해당 team 사람들 소속 없애기
		if (teamService.removeTeam(teamId)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("not_found", HttpStatus.NOT_FOUND);
	}
}
