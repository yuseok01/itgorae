package com.ssafy.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest6")
public class RestController6 {
	
	@GetMapping("/test1")
	public ResponseEntity<Void> test1(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/test2")
	public ResponseEntity<String> test2(){
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/test3")
	public ResponseEntity<String> test3(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		headers.add("Content-type", "text/plain;charset=UTF-8");
		return new ResponseEntity<String>("등록", headers, HttpStatus.OK);
	}
	
	@GetMapping("/test4")
	public ResponseEntity<User> test4(){
		User user = new User("ssafy", "ssafy", "ssafy");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}
