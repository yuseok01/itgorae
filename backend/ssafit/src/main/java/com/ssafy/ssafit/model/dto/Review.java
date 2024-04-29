package com.ssafy.ssafit.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "SSAFY")
public class Review {
	private int reviewId;
	private int videoId; 
	private String writerId;
	private String title;
	private String writer;
	private String content;
	private String date;
	private int ReviewViewCnt;
	
	public Review() {
		
	}
	
	public Review(int videoId, String writerId, String title, String writer, String content) {
		this.videoId = videoId;
		this.writerId= writerId;
		this.title = title;
		this.writer = writer;
		this.content = content;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.date = formatter.format(date);
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getWriterId() {
		return writerId;
	}
	
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int id) {
		this.reviewId = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getReviewViewCnt() {
		return ReviewViewCnt;
	}

	public void setReviewViewCnt(int viewCnt) {
		this.ReviewViewCnt = viewCnt;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
