package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		// 스프링 컨테이너 객체 빌드
		ApplicationContext context 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 객체 얻어오기
		// 코믹 영화를 보는 것까지 설정을 마친 audience 객체임
		Audience audience = context.getBean("audience", Audience.class);
		audience.seeMovie();

		// 그냥 기본 생성자로 Audience 객체 만들어볼까
		// 영화를 보려면 Movie를 구현한 객체를 넣어줘야한다.
		Audience audienceConst = context.getBean("audienceConst", Audience.class);
		Movie action = context.getBean("action", Action.class);
		audienceConst.setMovie(action);
		audienceConst.seeMovie();
		
//		------------------------------------------------------------------
		
		// 퀴즈1. 스프링 컨테이너는 빈 객체들을 언제 만들까?
		// 정답1. 컨테이너가 만들어질 때 (16번 라인)
		
		// 퀴즈2. 아래와 같이 audience객체를 또 사용한다면, audience 객체가 하나 더 만들어질까?
		Audience audience2 = context.getBean("audience", Audience.class);
		// 정답2. X (기본적인 정책은 싱글톤 singleton이므로, 컨테이너 빌드 시 딱 1번만 만든다.)
		System.out.println(audience == audience2);  // true
		// 관련 속성 : applicationContext.xml에서 Bean 등록 시에 활용할 수 있는 속성으로
		// 1) lazy-init="true"
		// 2) scope = "singleton"(기본값), scope = "prototype" (getBean할 때마다 새로운 객체를 생성한다.)
	}
}