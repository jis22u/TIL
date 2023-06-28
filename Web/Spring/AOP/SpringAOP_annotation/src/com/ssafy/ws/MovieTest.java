package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		// Target 객체를 구체적인 클래스 Audience로 하고 있음
		Person audience = context.getBean("audience", Audience.class);
		
		try {
			audience.doSomething();
		} catch (CallException e) {
//			e.printStackTrace();
		}
		
	}
}
