package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
		
	}

	@Override
	// user 테이블에서 해당 사용자가 있는지 확인
    public User getUser(String id) {
        return userDao.selectOne(id);
    }


	@Override
	// login 테이블
	public void logIn(String id) {
		userDao.loginUser(id);
		
	}


	@Override
	// login 테이블
	public void logOut(String id) {
		userDao.logoutUser(id);
	}

}
