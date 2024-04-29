package com.ssafy.ssafit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SSAFIT REST API")
	              .description("SSAFIT 영상 검색, 리뷰 CRUD, 유저 관리")
	              .version("v0.0.1")
	              .license(new License().name("SSAFY").url("http://www.ssafy.com")));
  }
}
