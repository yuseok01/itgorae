package com.ssafy.ssaccer.model.dto;

import java.time.LocalDateTime;

public class MatchBoard {
	private int boardId; // 고유번호
	private int myTeamId; // 우리 팀 아이디
	private int opposingTeamId; // 상대 팀 아이디
	private String myTeamName; // 우리 팀 이름
	private String opposingTeamName; //상대 팀 이름 
	private String title = ""; // A팀 vs B팀
	private String content = ""; // 경기내용
	private String videoUrl = ""; // 경기 영상 주소
	private String squadUrl = ""; // 스쿼드
	private int goals; // 골
	private int conceded; // 실
	private String result; // ENUM('win', 'loss', 'draw')와 대응
	private LocalDateTime createAt; // 생성 일자

	public MatchBoard() {
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getMyTeamId() {
		return myTeamId;
	}

	public void setMyTeamId(int myTeamId) {
		this.myTeamId = myTeamId;
	}

	public int getOpposingTeamId() {
		return opposingTeamId;
	}

	public void setOpposingTeamId(int opposingTeamId) {
		this.opposingTeamId = opposingTeamId;
	}

	public String getMyTeamName() {
		return myTeamName;
	}

	public void setMyTeamName(String myTeamName) {
		this.myTeamName = myTeamName;
	}

	public String getOpposingTeamName() {
		return opposingTeamName;
	}

	public void setOpposingTeamName(String opposingTeamName) {
		this.opposingTeamName = opposingTeamName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getSquadUrl() {
		return squadUrl;
	}

	public void setSquadUrl(String squadUrl) {
		this.squadUrl = squadUrl;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getConceded() {
		return conceded;
	}

	public void setConceded(int conceded) {
		this.conceded = conceded;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "MatchBoard [boardId=" + boardId + ", myTeamId=" + myTeamId + ", opposingTeamId=" + opposingTeamId
				+ ", myTeamName=" + myTeamName + ", opposingTeamName=" + opposingTeamName + ", title=" + title
				+ ", content=" + content + ", videoUrl=" + videoUrl + ", squadUrl=" + squadUrl + ", goals=" + goals
				+ ", conceded=" + conceded + ", result=" + result + ", createAt=" + createAt + "]";
	}
}
