package com.ssafy.debug.model.dto;

import java.time.LocalDate;

/**
 * 뮤지컬 정보를 전달하기 위한 DTO(Data Transfer Object) 클래스입니다.
 */
public class Musical {

	private Long id; // 뮤지컬의 고유 ID
	private String title; // 뮤지컬 제목
	private String composer; // 작곡가
	private LocalDate premiereDate; // 초연 날짜
	private String synopsis; // 줄거리 요약

	// 기본 생성자
	public Musical() {
	}

	// 매개변수가 있는 생성자
	public Musical(Long id, String title, String composer, LocalDate premiereDate, String synopsis) {
		this.id = id;
		this.title = title;
		this.composer = composer;
		this.premiereDate = premiereDate;
		this.synopsis = synopsis;
	}

	// Getter and Setter 메소드
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public LocalDate getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(LocalDate premiereDate) {
		this.premiereDate = premiereDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "MusicalDTO{" + "id=" + id + ", title='" + title + '\'' + ", composer='" + composer + '\''
				+ ", premiereDate=" + premiereDate + ", synopsis='" + synopsis + '\'' + '}';
	}
}