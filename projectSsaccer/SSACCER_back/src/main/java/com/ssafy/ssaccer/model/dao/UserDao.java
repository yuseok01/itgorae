package com.ssafy.ssaccer.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssaccer.model.dto.User;

public interface UserDao {
	// 사용자 전체 조회
	public List<User> selectAll();
	// 사용자 아이디 조회
	public User selectById(int userId);
	// 사용자 등록
	public void insertUser(User user);
	// 사용자 조회
	public User selectOne(User user);
	// 사용자 닉네임 조회
	public User selectByNickName(String nickName);
	// 사용자 팀 생성 시 -> 팀 아이디 수정, 유저 랭크 수정
	public void userCreateTeam(int userId, int teamId);
	// 팀 삭제 시 -> 팀 없음으로 수정, 유저 랭크 수정
	public void userDeletedTeam(int teamId);
	// 사용자 삭제
	public boolean deleteUser(int userId);
	// 사용자 수정
	public int updateUser(User user);
}
