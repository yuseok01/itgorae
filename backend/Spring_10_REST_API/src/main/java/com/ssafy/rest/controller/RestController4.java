package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest4")
public class RestController4 {
	// http://localhost:8080/mvc/rest4/board/1
	// http://localhost:8080/mvc/rest4/board/2
	// http://localhost:8080/mvc/rest4/board/99 -> 해당 숫자를 id로 갖는 게시글을 가져오고 싶다.
//	@PathVariable : URI 경로에 있는 값을 파라미터(변수) 추출해서 사용할래!
	
	@GetMapping("/board1/{id}")
	public String test1(@PathVariable int id) {
		return id +": board1";
	}
	
	@GetMapping("/board2/{id}")
	public String test2(@PathVariable("id") int no) {
		return no +": board2";
	}
	
	@GetMapping("/board3/{id}/reviews/{reviewId}")
	public String test3(@PathVariable("id") int id, @PathVariable int reviewId) {
		return "board "+id+"-> review : "+reviewId;
	}
	

}
