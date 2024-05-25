package com.ssafy.ssaccer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.MatchRequestDao;
import com.ssafy.ssaccer.model.dto.MatchRequest;

@Service
public class MatchRequestServiceImpl implements MatchRequestService {

	private final MatchRequestDao matchRequestDao;

	@Autowired
	public MatchRequestServiceImpl(MatchRequestDao matchRequestDao) {
		this.matchRequestDao = matchRequestDao;
	}

	// 매치 신청
	@Override
	public boolean makeRequest(MatchRequest matchRequest) {
		return matchRequestDao.insertRequest(matchRequest) == 1;
	}

	// 신청 받은 팀 매치리스트 조회
	@Override
	public List<MatchRequest> searchRequestById(int teamId) {
		return matchRequestDao.selectById(teamId);
	}

	// 매치 삭제(거절)
	@Override
	public boolean removeRequest(int matchRequestId) {
		return matchRequestDao.deleteRequest(matchRequestId) == 1;
	}

	@Override
	public MatchRequest searchRequest(MatchRequest matchRequest) {
		return matchRequestDao.selectMatchRequest(matchRequest);
	}
}
