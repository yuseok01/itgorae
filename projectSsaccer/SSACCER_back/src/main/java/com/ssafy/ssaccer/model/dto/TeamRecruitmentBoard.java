package com.ssafy.ssaccer.model.dto;

import java.time.LocalDateTime;

public class TeamRecruitmentBoard {
	private int id; // 게시판 고유번호
	private int recruitmentBoardId;
	private int teamId; // 팀 고유번호 참조
	private String teamName; // 팀이름
	private String teamImg; // 팀 로고
	private String title; // 모집 제목
	private String content; // 모집 내용
	private String status; // 모집 현황
	private LocalDateTime createAt; // 작성 일자

	// 기본 생성자
	public TeamRecruitmentBoard() {
	}

	// Getter 및 Setter 메서드

	public int getTeamId() {
		return teamId;
	}

	public int getId() {
		return id;
	}

	public int getRecruitmentBoardId() {
		return recruitmentBoardId;
	}

	public void setRecruitmentBoardId(int recruitmentBoardId) {
		this.recruitmentBoardId = recruitmentBoardId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTeamId(int teamId) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "TeamRecruitmentBoard [id=" + id + ", teamId=" + teamId + ", teamName=" + teamName + ", teamImg="
				+ teamImg + ", title=" + title + ", content=" + content + ", status=" + status + ", createAt="
				+ createAt + "]";
	}

}
