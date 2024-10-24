package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.rest.model.dto.User;

@Controller
@RequestMapping("/rest1")
public class RestController1 {
	//http://localhost:8080/mvc/rest1/test1 --> 404 가 떴어!
	//뷰리졸버에게 Hello REST API1 이 뷰네임으로 넘어갔다!
	@GetMapping("/test1")
	public String test1() {
		return "Hello REST API1";
	}
	
	//http://localhost:8080/mvc/rest1/test2
	//@ResponseBody 붙이면 이제 뷰리졸버에게 넘기는게 아니라 해당 반환값 자체를 클라이언트에게 준다.
	@GetMapping("/test2")
	@ResponseBody
	public String test2() {
		return "Hello REST API2";
	}
	
	//http://localhost:8080/mvc/rest1/test3
	//Map 자체를 반환해보겠다
	@GetMapping("/test3")
	@ResponseBody
	public Map<String, String> test3() {
		//키와 벨류
		Map<String, String> map = new HashMap<>();
		map.put("id", "ssafy");
		map.put("name", "Yang");
		map.put("password", "1234");
		//키:벨류인데 JSON 형태로 딱 알아서 바꿔주면 참 좋을텐데.... 
		//잭슨을 추가했더니 바꿔주더라 
		return map;
	}
	
	//http://localhost:8080/mvc/rest1/test4
	//DTO 자체를 반환해보겠다. JSON 알아서 쨱슨이 바꿔주더라
	@GetMapping("/test4")
	@ResponseBody
	public User test4() {
		User user = new User("ssafy1", "1234", "양띵균");
		return user;
	}
	
	
	//http://localhost:8080/mvc/rest1/test5
	//User 전체 조회
	@GetMapping("/test5")
	@ResponseBody
	public List<User> test5() {
		List<User>list = new ArrayList<>();
		
		list.add(new User("ssafy1", "1234", "양띵균"));
		list.add(new User("bokyeong", "5678", "이보경"));
		list.add(new User("hongsi", "0722", "연홍시"));
		list.add(new User("cdh", "1234", "최다환"));
		list.add(new User("woong", "086", "양지웅"));
		list.add(new User("lkh0131", "3969", "이강현"));
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
