package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.User;

public interface UserService {
	
	//전체 사용자 보내기 
	public List<User> getUserList();
	
	//사용자 등록하기 
	public int signUp(User user);
	
	//로그인
	public User login(String id, String password);
	
	//유저 사용자 이미지 넣기 
//	public User insertImg(User user);
}
