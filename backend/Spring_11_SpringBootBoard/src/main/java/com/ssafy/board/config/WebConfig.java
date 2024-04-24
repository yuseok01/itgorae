package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ssafy.board.interceptor.AdminPageInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix;
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		//가져오지 않고 직접 작성가능
		resolver.setPrefix(prefix); 
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class); //없어도 동작함. 명확하게 하려고 작성한것뿐
		return resolver;

	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	
	//주입하는 방법 3가지 중 아주 심플하게 주입해보자
	@Autowired
	AdminPageInterceptor adminPageInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminPageInterceptor).addPathPatterns("/users");
	}
	
	
	
	
	
	
	
}
