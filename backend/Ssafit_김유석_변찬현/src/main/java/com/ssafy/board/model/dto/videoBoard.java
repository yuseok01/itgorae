package com.ssafy.board.model.dto;

public class videoBoard {
	private static int videoNo;
	private String title;
	private String part;
	private String description;
	private String videoUrl;
	private String uploaderId;
	private int uploadDate;
	private int viewCnt;
	
	
	public videoBoard() {}

	public videoBoard(String title, String part, String description , String videoUrl, String uploaderId, int uploadDate, int viewCnt) {
		this.title = title;		
		this.part = part;
		this.description = description;
		this.videoUrl = videoUrl;
		this.uploaderId = uploaderId;
		this.uploadDate = uploadDate;
		this.viewCnt = viewCnt;
	}

	

	public static int getVideoNo() {
		return videoNo;
	}

	public static void setVideoNo(int videoNo) {
		videoBoard.videoNo = videoNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getUploaderId() {
		return uploaderId;
	}

	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}

	public int getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(int uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "videoBoard [title=" + title + ", part=" + part + ", description=" + description + ", videoUrl="
				+ videoUrl + ", uploaderId=" + uploaderId + ", uploadDate=" + uploadDate + ", viewCnt=" + viewCnt + "]";
	}

	
	
}
