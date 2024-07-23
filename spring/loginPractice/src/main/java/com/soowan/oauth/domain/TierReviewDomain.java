package com.soowan.oauth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tier_reviews")
@Getter
@Setter
@NoArgsConstructor
public class TierReviewDomain {
	@Id
	//length는 길이, columnDefinition은 text등 특정 타입 지정
	@Column(name = "tier_reviewId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tierReviewId;
	
	@ManyToOne //리뷰가 many user가 one 유저는 여러개의 리뷰를 적을 수 있다.
	@JoinColumn(name = "email") //조인하는 컬럼명 //유저의 테이브에서 email를 결합함
	private UserDomain user;
	
	@Column(name = "tier_review", columnDefinition = "TEXT")
	private String tierReview;
	
	@Column(name = "tier")
	@Enumerated(EnumType.ORDINAL)
	private TierStatus tier;
	
	
	
}
