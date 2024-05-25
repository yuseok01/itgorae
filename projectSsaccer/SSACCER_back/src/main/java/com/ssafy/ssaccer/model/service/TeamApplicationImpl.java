package com.ssafy.ssaccer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.TeamApplicationDao;
import com.ssafy.ssaccer.model.dto.TeamApplication;

@ Service
public class TeamApplicationImpl implements TeamApplicationService{
	private final TeamApplicationDao teamApplicationDao;
	
	@Autowired
	public TeamApplicationImpl(TeamApplicationDao teamApplicationDao) {
		super();
		this.teamApplicationDao = teamApplicationDao;
	}
	
	
	@Override
	public List<TeamApplication> searchByTeamId(int teamId) {
		return teamApplicationDao.selectByTeamId(teamId);
	}


	@Override
	public TeamApplication searchById(int id) {
		return teamApplicationDao.selectById(id);
	}

	@Override
	public boolean removeApplication(int id) {
		return teamApplicationDao.deleteApplication(id) == 1;
	}


	@Override
	public boolean writeApplication(TeamApplication teamApplication) {
		return teamApplicationDao.insertApplication(teamApplication) == 1;
	}


	@Override
	public boolean acceptApplication(int applicationId) {
		return teamApplicationDao.setApproved(applicationId) == 1;
	}


	@Override
	public boolean rejectApplication(int applicationId) {
		return teamApplicationDao.setRejected(applicationId) == 1;
	}



}
