package com.soowan.oauth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "user")
public class UserDomain {

	@Id
	@Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = true) //이메일 , 식별자?
	private String email;

	@Column(name = "oauth_type", columnDefinition = "VARCHAR(50)") //가져온 api 주체
	private String oauthType;

	@Column(name = "security_grade", columnDefinition = "Integer") //보안 등급 (접근 가능영역을 정하기 위해)
	private int securityGrade;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOauthType() {
		return oauthType;
	}

	public void setOauthType(String oauthType) {
		this.oauthType = oauthType;
	}

	public int getSecurityGrade() {
		return securityGrade;
	}

	public void setSecurityGrade(int securityGrade) {
		this.securityGrade = securityGrade;
	}
	 
}
