package com.ssafit.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao; //의존성 주입 
	}
	
	@Override //유저정보조회
	public List<User> getUserList() {
		return userDao.selectAll();
		
		
	}

	@Override //로그인
	public int signUp(User user) {
		return userDao.insertUser(user); 
	}

	@Override
	public User login(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password); 
		return userDao.selectOne(map); //id와 password넣고 보내기
	}
	
}
