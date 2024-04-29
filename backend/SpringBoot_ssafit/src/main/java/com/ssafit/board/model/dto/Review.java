package com.ssafit.board.model.dto;

@Schema(description = "리뷰")
public class Review {
	
	private int No;
	private String userId;
	private int videoNo;
	private String title;
	private String content;
	private int rating;
	private String reviewDate;
	
	public Review () {}
	
	public Review(int No, String userId, int videoNo, String title, String content, int rating,
			String reviewDate) {
		super();
		this.No = No;
		this.userId = userId;
		this.videoNo = videoNo;
		this.title = title;
		this.content = content;
		this.rating = rating;
		this.reviewDate = reviewDate;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
