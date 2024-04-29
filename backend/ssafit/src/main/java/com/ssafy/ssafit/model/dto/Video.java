package com.ssafy.ssafit.model.dto;

public class Video {
	private int videoId;
	private String title;
	private String part;
	private String url;
	private int viewCnt;

	public Video() {
		
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	public Video(int videoId, String title, String part, String url) {
		this.videoId = videoId;
		this.title = title;
		this.part = part;
		this.url = url;
	}

	public int getVidId() {
		return videoId;
	}

	public void setVidId(int vidId) {
		this.videoId = vidId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
