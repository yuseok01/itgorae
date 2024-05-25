package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.User;

public interface UserService {
	// 전체 유저 조회
	public List<User> getUserList();
	// 아이디 유저 조회
	public User getUserById(int userId);
	// 회원가입
	public void signup(User user);
	// 로그인
	public User login(User user);
	// 닉네임 조회
	public User searchByNickName(String nickName);
	// 사용자 팀 생성 -> 팀 소속, 팀 이름, 사용자 랭크 (1로)수정
	public void userCreateTeam(int userId, int teamId);
	// 팀 삭제시 유저 소속 없애기
	public void userRemovedTeam(int teamId);
	// 유저 수정
	public boolean modifyUser(User user);
	// 유저 삭제
	public boolean removeUser(int userId);
}
