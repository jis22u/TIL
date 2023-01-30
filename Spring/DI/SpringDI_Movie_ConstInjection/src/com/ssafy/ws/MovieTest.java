package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		// 스프링 컨테이너 객체 빌드
		ApplicationContext context 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 객체 얻어오기
		Audience audience = context.getBean("audience", Audience.class);
		audience.seeMovie();
		
		// 이제 액션 영화 보고 싶어
		Movie action = context.getBean("action", Action.class);
		audience.setMovie(action);
		audience.seeMovie();
	}
}
