package com.ssafy.ssaccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.service.TeamService;
import com.ssafy.ssaccer.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "UserRestController", description = "회원가입/로그인/로그아웃")
public class UserRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private final UserService userService;
	private final TeamService teamService;

	@Autowired
	public UserRestController(UserService userService, TeamService teamService) {
		super();
		this.userService = userService;
		this.teamService = teamService;
	}

	// 로그인
	@PostMapping("/login")
	@Operation(summary = "로그인")
	public ResponseEntity<?> login(@RequestBody User user) {
		User tmp = userService.login(user);
		if(tmp != null) {
			Team team = teamService.searchByTeamId(tmp.getTeamId());
			tmp.setTeamName(team.getTeamName());
			System.out.println(tmp);
			return new ResponseEntity<User>(tmp, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

	// 사용자 전체 조회
	@GetMapping("/searchAll")
	@Operation(summary = "조회")
	public ResponseEntity<List<User>> selectAll() {
		List<User> list = userService.getUserList();
		return new ResponseEntity<List<User>>(list, HttpStatus.ACCEPTED);
	}
	
	// 아이디 사용자 조회
	@GetMapping("/searchById/{id}")
	public ResponseEntity<User> selectById(@PathVariable("id") int userId) {
		User user = userService.getUserById(userId);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		Team team = teamService.searchByTeamId(user.getTeamId());
		user.setTeamName(team.getTeamName());
		System.out.println(user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	// 닉네임 조회
	@GetMapping("/search/{nickName}")
	@Operation(summary = "닉네임 조회")
	public ResponseEntity<User> selectByNickName(@PathVariable("nickName") String nickName) {
		User user = userService.searchByNickName(nickName);
		if (user == null) { // 닉네임 사용가능
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST); // 사용 불가
	}

	@PostMapping("/signup")
	@Operation(summary = "회원가입")
	public ResponseEntity<User> signup(@RequestBody User user) {
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@Operation(summary = "회원정보 수정")
	public ResponseEntity<String> update(@RequestBody User user) {
		if (userService.modifyUser(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/user/{id}")
	@Operation(summary = "회원 삭제")
	public ResponseEntity<String> delete(@PathVariable("id") int userId) {
		if (userService.removeUser(userId))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
