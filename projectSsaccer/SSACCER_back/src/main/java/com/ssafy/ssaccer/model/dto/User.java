package com.ssafy.ssaccer.model.dto;

public class User {
	private int userId;
	private String userName; // 이름
	private String nickName; // 닉네임
	private String email; // 이메일
	private String password; // 비밀번호
	private String userImage; // 사진 경로
	private int userGoals; //
	private int userAssists;
	private int userRank;
	private String position;
	private int teamId = 1;
	private String teamName;
	private String accessToken; // JWT 토큰

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public int getUserGoals() {
		return userGoals;
	}

	public void setUserGoals(int userGoals) {
		this.userGoals = userGoals;
	}

	public int getUserAssists() {
		return userAssists;
	}

	public void setUserAssists(int userAssists) {
		this.userAssists = userAssists;
	}

	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTeamId() {
		return teamId;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", email=" + email
				+ ", password=" + password + ", userImage=" + userImage + ", userGoals=" + userGoals + ", userAssists="
				+ userAssists + ", userRank=" + userRank + ", position=" + position + ", teamId=" + teamId
				+ ", teamName=" + teamName + ", accessToken=" + accessToken + "]";
	}
}
