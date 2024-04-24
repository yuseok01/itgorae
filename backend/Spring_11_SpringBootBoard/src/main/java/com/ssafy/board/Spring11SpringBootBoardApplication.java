package com.ssafy.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring11SpringBootBoardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring11SpringBootBoardApplication.class, args);
		
		for(String beanName: context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}

}
