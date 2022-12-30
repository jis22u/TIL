package com.ssafy.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// @Configuration
//  : 해당 파일은 설정 파일이다
//  : 설정을 xml이 아닌 자바 Config 파일로 하겠다
@Configuration
@MapperScan(basePackages = "com.ssafy.board.model.dao")
public class DBConfig {

}
