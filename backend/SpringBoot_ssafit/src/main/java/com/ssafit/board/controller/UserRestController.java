package com.ssafit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.User;
import com.ssafit.board.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-user")
@Tag(name = "UserRestController", description = "유저 관련 API")
//@CrossOrigin("*")
public class UserRestController {

	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	@Operation(summary = "로그인", description = "로그인 가넝")
	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session){
		User loginUser = userService.login(user.getId(), user.getPassword());
		session.setAttribute("loginUser", loginUser);
		return new ResponseEntity<User>(loginUser, HttpStatus.OK);
	}

	@GetMapping("/logout")
	@Operation(summary = "로그아웃", description = "로그아웃 가넝")
	public ResponseEntity<?> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/signup")
	@Operation(summary = "회원가입", description = "회원가입 가넝")
	public ResponseEntity<?> signup(@ModelAttribute User user){
		if(userService.signup(user) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}

}
