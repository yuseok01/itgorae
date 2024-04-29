package com.ssafit.board.model.dto;


@Schema(description = "유저 정보")
public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String img;
	
	public User() {}

	public User(String userId, String userPassword, String userName , String img) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.img = img;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
