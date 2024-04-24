package com.ssafy.debug.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.debug.model.dao")
@Configuration
public class MyBatisConfig {

}
