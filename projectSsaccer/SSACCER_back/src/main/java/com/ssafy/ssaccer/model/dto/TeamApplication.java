package com.ssafy.ssaccer.model.dto;

import java.time.LocalDateTime;

public class TeamApplication {
	// 이름, 닉네임, 포지션, 지역
	private int id; // 신청 고유번호
	private int recruitmentBoardId; // 모집 게시판 고유번호 참조
	private int teamId; // 팀 고유번호 참조
	private int userTeamId;
	private String userTeamName;
	private int userId; // 신청자 ID
	private String userName; // 이름
	private String nickName; // 닉네임
	private String position; // 포지션
	private String title; // 신청 제목
	private String content; // 신청 내용 또는 메시지
	private LocalDateTime applicationDate; // 신청 일자
	private String applicationStatus; // 신청 상태(대기 중, 승인됨, 거절됨)

	// Constructors
	public TeamApplication() {
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecruitmentBoardId() {
		return recruitmentBoardId;
	}

	public void setRecruitmentBoardId(int recruitmentBoardId) {
		this.recruitmentBoardId = recruitmentBoardId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getUserTeamId() {
		return userTeamId;
	}

	public void setUserTeamId(int userTeamId) {
		this.userTeamId = userTeamId;
	}

	public String getUserTeamName() {
		return userTeamName;
	}

	public void setUserTeamName(String userTeamName) {
		this.userTeamName = userTeamName;
	}

	@Override
	public String toString() {
		return "TeamApplication [id=" + id + ", recruitmentBoardId=" + recruitmentBoardId + ", teamId=" + teamId
				+ ", userTeamId=" + userTeamId + ", userTeamName=" + userTeamName + ", userId=" + userId + ", userName="
				+ userName + ", nickName=" + nickName + ", position=" + position + ", title=" + title + ", content="
				+ content + ", applicationDate=" + applicationDate + ", applicationStatus=" + applicationStatus + "]";
	}
}
