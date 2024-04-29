package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	//사용자 등록하기
	public void signup(User user);
	//로그인 하기
	public User getUser(String id);
	public void logIn(String id);
	public void logOut(String id);
}
