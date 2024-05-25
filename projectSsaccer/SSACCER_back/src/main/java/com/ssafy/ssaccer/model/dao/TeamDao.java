package com.ssafy.ssaccer.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssaccer.model.dto.Team;

public interface TeamDao {
	// 전체 팀 조회
	public List<Team> selectAll();
	// 아이디로 팀 조회
	public Team selectOne(int teamId);
	// 팀 생성
	public void insertTeam(String teamName);
	// 팀 수정
	public int updateTeam(Team team);
	// 팀 삭제
	public int deleteTeam(int teamId);
	// 마지막 아이디 조회
	public int selectLastId();
}
