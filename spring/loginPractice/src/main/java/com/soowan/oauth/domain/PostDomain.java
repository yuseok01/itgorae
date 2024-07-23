package com.soowan.oauth.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostDomain {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@ManyToOne //리뷰가 many user가 one 유저는 여러개의 리뷰를 적을 수 있다.
	@JoinColumn(name = "email") //조인하는 컬럼명 //유저의 테이브에서 email를 결합함
	private UserDomain user;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "image")
	private String image;
	
	@CreationTimestamp
	@Column(name = "created_At")
	private LocalDateTime createdAt;
	

}
