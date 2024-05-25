package com.ssafy.ssaccer.model.dto;

import java.time.LocalDateTime;

public class MatchRequest {
	private int matchRequestId; // 시합 요청 고유 번호
	private int teamIdFrom; // 요청 팀 고유번호
	private int teamIdTo; // 요청받은 팀 고유번호
	private String teamNameFrom; // 요청 팀 이름
	private String teamNameTo; // 요청 팀 이름
	private LocalDateTime createAt; // 요청 생성 시간
	
	// 신청 팀 정보
	private int points; // 승점
	private int goals; // 득점
	private int assists; // 도움
	private int conceded; // 실점
	private int won; // 승
	private int drawn; // 무
	private int lost; // 패
	private int played; // 총 경기수
	private String region; // 활동 지역
	private String matchTime; // 활동 시간
	private String homeStadium; // 홈 구장
	

	public MatchRequest() {
	}


	public int getMatchRequestId() {
		return matchRequestId;
	}


	public void setMatchRequestId(int matchRequestId) {
		this.matchRequestId = matchRequestId;
	}


	public int getTeamIdFrom() {
		return teamIdFrom;
	}


	public void setTeamIdFrom(int teamIdFrom) {
		this.teamIdFrom = teamIdFrom;
	}


	public int getTeamIdTo() {
		return teamIdTo;
	}


	public void setTeamIdTo(int teamIdTo) {
		this.teamIdTo = teamIdTo;
	}


	public String getTeamNameFrom() {
		return teamNameFrom;
	}


	public void setTeamNameFrom(String teamNameFrom) {
		this.teamNameFrom = teamNameFrom;
	}


	public String getTeamNameTo() {
		return teamNameTo;
	}


	public void setTeamNameTo(String teamNameTo) {
		this.teamNameTo = teamNameTo;
	}


	public LocalDateTime getCreateAt() {
		return createAt;
	}


	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getGoals() {
		return goals;
	}


	public void setGoals(int goals) {
		this.goals = goals;
	}


	public int getAssists() {
		return assists;
	}


	public void setAssists(int assists) {
		this.assists = assists;
	}


	public int getConceded() {
		return conceded;
	}


	public void setConceded(int conceded) {
		this.conceded = conceded;
	}


	public int getWon() {
		return won;
	}


	public void setWon(int won) {
		this.won = won;
	}


	public int getDrawn() {
		return drawn;
	}


	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}


	public int getLost() {
		return lost;
	}


	public void setLost(int lost) {
		this.lost = lost;
	}


	public int getPlayed() {
		return played;
	}


	public void setPlayed(int played) {
		this.played = played;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getMatchTime() {
		return matchTime;
	}


	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}


	public String getHomeStadium() {
		return homeStadium;
	}


	public void setHomeStadium(String homeStadium) {
		this.homeStadium = homeStadium;
	}


	@Override
	public String toString() {
		return "MatchRequest [matchRequestId=" + matchRequestId + ", teamIdFrom=" + teamIdFrom + ", teamIdTo="
				+ teamIdTo + ", teamNameFrom=" + teamNameFrom + ", teamNameTo=" + teamNameTo + ", createAt=" + createAt
				+ ", points=" + points + ", goals=" + goals + ", assists=" + assists + ", conceded=" + conceded
				+ ", won=" + won + ", drawn=" + drawn + ", lost=" + lost + ", played=" + played + ", region=" + region
				+ ", matchTime=" + matchTime + ", homeStadium=" + homeStadium + "]";
	}
}
