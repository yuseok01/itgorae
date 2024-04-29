package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//로그인 페이지 주세요
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	//로그인 해주세요
	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
//		
//	}
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());
		//tmp에 들어갈 수 있는 값은?
		//1. 실제로 로그인 잘 되었다면 유저객체가 반환이 되어 사용할 수 있음
		//2. 뭔가 아이디나 비밀번호가 틀렸어! null
		if(tmp == null)
			return "redirect:login";
		
		//로그인 성공 (세션 영역에 정보를 저장했다)
		session.setAttribute("loginUser", tmp.getName());
		return "redirect:list";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate();
		//리스트 화면으로 갔는데, 로그인페이지로 보낼 수도 있다.
		return "redirect:list";
	}
	
	//유저등록
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signupform";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		//성공적으로 회원가입이 되었어!
		//1. 회원가입 축하합니다. 페이지로 이동
		//2. 로그인 페이지로 이동(v)
		//3. 게시글 목록 화면으로 이동
		//3-1. 지금 User 객체를 그대로 실어서 로그인 요청을 보내기
		//3-2. 세션불러다가 직접 등록해버리고 넘어가
		
		return "redirect:login";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}
	
	
	
	
	
	
	
	
	
	
}
