package com.soowan.oauth.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.soowan.oauth.domain.UserDomain;
import com.soowan.oauth.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service	
public class UserService extends DefaultOAuth2UserService{
	
	@Autowired UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		
		//email, oauthType 호출
		Map<String, Object> attributes = super.loadUser(userRequest).getAttributes();
//		log.info("ATTR INFO : {}", attributes.toString());
		
		String email = null;
		String oauthType = userRequest.getClientRegistration().getRegistrationId();
		
		OAuth2User user2 = super.loadUser(userRequest);
		
		//oauth 타입에 따라 데이터가 다르기에 분기
		if("google".equals(oauthType.toLowerCase())) {
			email = attributes.get("email").toString();
		}
		
		// user 존재 여부 확인 및 없으면 생성
		if(getUserByEmailAndOAuthType(email, oauthType) == null) {
//			
			UserDomain user = new UserDomain();
			user.setEmail(email);
			user.setOauthType(oauthType);
			save(user);
		}
		
		return super.loadUser(userRequest);
		
	}

	public void save(UserDomain user) {
		userRepository.save(user);
		
	}

	public UserDomain getUserByEmailAndOAuthType(String email, String oauthType) {
		return userRepository.findByEmailAndOauthType(email, oauthType).orElse(null);
	}

}
