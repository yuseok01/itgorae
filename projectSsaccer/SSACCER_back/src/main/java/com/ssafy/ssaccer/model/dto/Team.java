package com.ssafy.ssaccer.model.dto;

public class Team {
	private int teamId;
	private String teamName; // 팀 이름
	private String teamImg; // 팀 로고
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

	public Team() {
	}

	public int getId() {
		return teamId;
	}

	public void setId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamImg() {
		return teamImg;
	}

	public void setTeamImg(String teamImg) {
		this.teamImg = teamImg;
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
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamimg=" + teamImg + ", points=" + points
				+ ", goals=" + goals + ", assists=" + assists + ", conceded=" + conceded + ", won=" + won + ", drawn="
				+ drawn + ", lost=" + lost + ", played=" + played + ", region=" + region + ", matchTime=" + matchTime
				+ ", homeStadium=" + homeStadium + "]";
	}
}
