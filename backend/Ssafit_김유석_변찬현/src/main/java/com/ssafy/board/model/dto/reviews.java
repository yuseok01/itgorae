package com.ssafy.board.model.dto;

public class reviews {
	  public int reviewSeq; //auto increment
	  String content;
	  int rating;
	  String userId;
	  int videoSeq;
	  int reviewDate;
	
	public reviews() {}

	public reviews( String content, int rating, String userId, int videoSeq, int reviewData) {
		this.content = content;
		this.rating = rating;
		this.userId = userId;
		this.videoSeq = videoSeq;
		this.reviewDate = reviewData;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(int videoSeq) {
		this.videoSeq = videoSeq;
	}

	public int getReviewData() {
		return reviewDate;
	}

	public void setReviewData(int reviewData) {
		this.reviewDate = reviewData;
	}
}
