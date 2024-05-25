package com.ssafy.ssaccer.model.dao;

import java.util.List;

import com.ssafy.ssaccer.model.dto.TeamApplication;

public interface TeamApplicationDao {
	// 팀에서 신청 내역 조회
	public List<TeamApplication> selectByTeamId(int teamId);
	
	// 신청 아이디로 조회
	public TeamApplication selectById(int id);
	
	// 신청 삭제
	public int deleteApplication(int id);
	
	// 가입 신청하기
	public int insertApplication(TeamApplication teamApplication);
	
	// 신청 수락
	public int setApproved(int applicationId);
	
	// 신청 거절
	public int setRejected(int applicationId);
}
