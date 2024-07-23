package com.soowan.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
}
