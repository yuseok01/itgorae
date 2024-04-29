package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	public void insertUser(User user);
	public User selectOne(String id);
	public void loginUser(String id);
	public void logoutUser(String id);
}
