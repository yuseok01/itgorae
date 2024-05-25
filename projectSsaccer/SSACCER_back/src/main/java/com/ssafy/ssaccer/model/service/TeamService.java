package com.ssafy.ssaccer.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.ssaccer.model.dto.Team;

public interface TeamService {
	// 전체 팀 조회
	public List<Team> getTeamList();
	// 아이디로 팀 조회
	public Team searchByTeamId(int teamId);
	// 팀 생성
	public void createTeam(String teamName);
	// 팀 수정
	public boolean modifyTeam(Team team);
	// 팀 삭제
	public boolean removeTeam(int teamId);
	// 마지막 팀 번호 조회
	public int getLastId();
}
