package com.ssafit.board.model.dto;

public class Video {

	private int no;
	private String title;
	private String part;
	private String description;
	private String url;
	private String userId;
	private String uploadDate;
	private int viewCnt;
	
	public Video() {}
	
	public Video(int no, String title, String part, String description, String url, String userId, String uploadDate,
			int viewCnt) {
		super();
		this.no = no;
		this.title = title;
		this.part = part;
		this.description = description;
		this.url = url;
		this.userId = userId;
		this.uploadDate = uploadDate;
		this.viewCnt = viewCnt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
