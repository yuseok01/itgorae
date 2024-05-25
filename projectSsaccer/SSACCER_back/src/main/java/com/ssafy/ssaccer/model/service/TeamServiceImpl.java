package com.ssafy.ssaccer.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.TeamDao;
import com.ssafy.ssaccer.model.dto.Team;

@Service
public class TeamServiceImpl implements TeamService {
	private final TeamDao teamDao;

	@Autowired
	public TeamServiceImpl(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public List<Team> getTeamList() {
		return teamDao.selectAll();
	}

	@Override
	public Team searchByTeamId(int teamId) {
		return teamDao.selectOne(teamId);
	}

	@Override
	public void createTeam(String teamName) {
		teamDao.insertTeam(teamName);
	}

	@Override
	public int getLastId() {
		return teamDao.selectLastId();
	}

	@Override
	public boolean removeTeam(int teamId) {
		return teamDao.deleteTeam(teamId) == 1;
	}

	@Override
	public boolean modifyTeam(Team team) {
		return teamDao.updateTeam(team) == 1;
	}
}
