package com.soowan.oauth.config.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.soowan.oauth.domain.UserDomain;
import com.soowan.oauth.user.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuthLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		
		//토큰에서 email. oauthType 추출
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
		
		String email = null;
		String oauthType = token.getAuthorizedClientRegistrationId();
		
		
		if("google".equals(oauthType.toLowerCase())) {
			email = token.getPrincipal().getAttribute("email").toString();
		}
		
//		System.out.println("성공");
		
		UserDomain user = userService.getUserByEmailAndOAuthType(email, oauthType);
		
		//세선에 user 저장
//		System.out.println("거시기");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		super.onAuthenticationSuccess(request, response, authentication);
		
	}
	
	
}
