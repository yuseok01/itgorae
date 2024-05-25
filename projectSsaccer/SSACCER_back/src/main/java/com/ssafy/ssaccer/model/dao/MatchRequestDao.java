package com.ssafy.ssaccer.model.dao;

import java.util.List;

import com.ssafy.ssaccer.model.dto.MatchRequest;

public interface MatchRequestDao {
	// 매치 신청
	public int insertRequest(MatchRequest matchRequest);

	// 매치리스트 조회 (받은 팀 기준)
	public List<MatchRequest> selectById(int teamId);

	// 매치 삭제
	public int deleteRequest(int matchRequestId);
	
	public MatchRequest selectMatchRequest(MatchRequest matchRequest);

	// 매치 조회
	// public List<MatchRequest> selectAll();
}
