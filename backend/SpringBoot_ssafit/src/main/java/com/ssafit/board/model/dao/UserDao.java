package com.ssafit.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafit.board.model.dto.User;

public interface UserDao {
	public List<User> selectAll();
	
	public int insertUser(User user); 
	
	public User selectOne(Map<String,String> info);
	
	public User selectById(User userId);
}
