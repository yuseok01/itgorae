package com.ssafy.ssaccer.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.UserDao;
import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, JwtUtil jwtUtil) {
		this.userDao = userDao;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(User user) {
		User tmp = userDao.selectOne(user);
		if (tmp != null) {
			tmp.setAccessToken(jwtUtil.createToken(tmp.getEmail()));
		}
		return tmp;
	}

	@Override
	public User searchByNickName(String nickName) {
		return userDao.selectByNickName(nickName);
	}

	@Override
	public void userCreateTeam(int userId, int teamId) {
		userDao.userCreateTeam(userId, teamId);
	}

	@Override
	public User getUserById(int userId) {
		return userDao.selectById(userId);
	}

	@Override
	public void userRemovedTeam(int teamId) {
		userDao.userDeletedTeam(teamId);
	}


	@Override
	public boolean removeUser(int userId) {
		return userDao.deleteUser(userId);
	}
	
	@Override
	public boolean modifyUser(User user) {
		return userDao.updateUser(user) == 1;
	}
}
