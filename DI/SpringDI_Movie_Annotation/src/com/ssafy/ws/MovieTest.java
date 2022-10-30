package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


//1. 메이븐을 통해서 우리 프로젝트에 Spring 라이브러리 세팅
//2. 스프링 설정파일 만들고 객체(bean) 등록하기
//3. 스프링 컨테이너 객체 빌드 및 사용

public class MovieTest {
	public static void main(String[] args) {
		// 3-1. 스프링 컨테이너 객체 빌드
		ApplicationContext context 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 3-2. 컨테이너로부터 내가 사용할 객체를 받아온다.
		Audience audience = context.getBean("audience", Audience.class);
		audience.seeMovie();
	}
}




// <Audience 객체 만들기>
// 1. @Component로 객체들 생성만 하고 @Autowired(의존성 주입)하지 않은 경우
// 	  - 매개변수 있는 생성자만 필요
//    - 객체를 생성할 때 알아서 매개변수 있는 생성자 호출해서 Movie 객체 넣어주고 Audience 객체를 생성함