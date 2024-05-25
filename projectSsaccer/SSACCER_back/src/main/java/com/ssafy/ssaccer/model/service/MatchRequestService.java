package com.ssafy.ssaccer.model.service;

import java.util.List;

import com.ssafy.ssaccer.model.dto.MatchRequest;

public interface MatchRequestService {
	// 매치 신청
	public boolean makeRequest(MatchRequest matchRequest);
	// 매치 상세조회 (받은 팀 기준)
	public List<MatchRequest> searchRequestById(int teamId);
	// 매치 삭제
	public boolean removeRequest(int matchRequestId);
	// 매치 조회
	public MatchRequest searchRequest(MatchRequest matchRequest);
	
	// 매치 전체 조회
	// public List<MatchRequest> searchRequest();
	
	// 매치 신청 수정 - 구현 의미 고민
	// public boolean modifyRequest(MatchRequest matchRequest);
}
