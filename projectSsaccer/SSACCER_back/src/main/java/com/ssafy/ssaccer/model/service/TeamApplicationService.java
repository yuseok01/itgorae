package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.TeamApplication;

public interface TeamApplicationService {
	// 팀에서 신청 내역 조회
	public List<TeamApplication> searchByTeamId(int teamId);

	// 신청 아이디로 조회
	public TeamApplication searchById(int id);

	// 신청 삭제
	public boolean removeApplication(int id);
	
	// 가입신청하기
	public boolean writeApplication(TeamApplication teamApplication);
	
	// 신청 수락
	public boolean acceptApplication(int applicationId);
	
	// 신청 거절
	public boolean rejectApplication(int applicationId);
}
