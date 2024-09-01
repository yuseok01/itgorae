package com.soowan.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.soowan.oauth.config.handler.OAuthLoginFailureHandler;
import com.soowan.oauth.config.handler.OAuthLoginSuccessHandler;
import com.soowan.oauth.user.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	OAuthLoginSuccessHandler oAuthLoginSuccessHandler;
	@Autowired
	OAuthLoginFailureHandler oAuthLoginFailureHandler;
	@Autowired
	UserService userService;

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
		return http
				.authorizeHttpRequests( auth ->{
					auth.requestMatchers("/login").permitAll();
					auth.anyRequest().authenticated();
				})
				.oauth2Login(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.build();
    }
}
