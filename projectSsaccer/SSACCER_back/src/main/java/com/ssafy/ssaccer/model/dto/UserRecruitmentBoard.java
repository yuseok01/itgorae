package com.ssafy.ssaccer.model.dto;

import java.time.LocalDateTime;

public class UserRecruitmentBoard {
	private int userRecruitmentId; // 게시판 고유 번호
	private int userId; // 사용자 아이디
	private int teamId; // 소속 팀
	private String title; // 제목
	private String content; // 내용
	private String teamName; // 소속 팀이름
	private String region; // 희망 지역
	private String position; // 포지션
	private LocalDateTime createdAt; // 작성 일자

	public UserRecruitmentBoard() {
	}

	public int getUserRecruitmentId() {
		return userRecruitmentId;
	}

	public void setUserRecruitmentId(int userRecruitmentId) {
		this.userRecruitmentId = userRecruitmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserRecruitmentBoard [userRecruitmentId=" + userRecruitmentId + ", userId=" + userId + ", teamId="
				+ teamId + ", title=" + title + ", content=" + content + ", teamName=" + teamName + ", region=" + region
				+ ", position=" + position + ", createdAt=" + createdAt + "]";
	}
}
