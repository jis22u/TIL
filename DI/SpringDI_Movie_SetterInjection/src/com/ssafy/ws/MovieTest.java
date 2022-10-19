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

		// 그냥 기본 생성자로 Audience 객체 만들어볼까
		// 영화를 보려면 Movie를 구현한 객체를 넣어줘야한다.
		Audience audienceConst = context.getBean("audienceConst", Audience.class);
		Movie action = context.getBean("action", Action.class);
		audienceConst.setMovie(action);
		audienceConst.seeMovie();
	}
}