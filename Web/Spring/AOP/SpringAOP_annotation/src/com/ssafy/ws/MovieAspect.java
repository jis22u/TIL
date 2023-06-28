package com.ssafy.ws;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Aspect 클래스를 Bean 등록하기 위해서 @Component annotation 사용
// @Aspect Annotation으로 해당 클래스가 Aspect임을 선언, Aspect로서 동작하도록 한다.
@Component
@Aspect
public class MovieAspect {
	
	@Pointcut("execution( public int com.ssafy.ws.*.doSomething() )")
	public void mypt() {
		
	}
	
	@Before("mypt()")
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
	
	// 정상적으로 끝났을 때
	@AfterReturning(value = "mypt()", returning = "num")
	public void afterReturning(int num) {
		System.out.println("영화가 끝나고 나옵니다.");
	}
	
	// 문제가 발생하면서 끝났을 때
	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("전화를 받습니다.");
		if( th instanceof CallException) {
			((CallException)th).handleException();
		}
	}
	
	// 어쨌든 끝났을 때
	@After("mypt()")
	public void after() {
		System.out.println("집에 갑니다.");
	}
}
