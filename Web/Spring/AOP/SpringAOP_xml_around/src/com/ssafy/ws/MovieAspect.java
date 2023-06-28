package com.ssafy.ws;

import org.aspectj.lang.ProceedingJoinPoint;

// 2. Aspect(공통 관심사항) 구현
public class MovieAspect {
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
	
	// 정상적으로 끝났을 때
	public void afterReturning(int num) {
		System.out.println("영화가 끝나고 나옵니다.");
	}
	
	// 문제가 발생하면서 끝났을 때
	public void afterThrowing(Throwable th) {
		System.out.println("전화를 받습니다.");
		if( th instanceof CallException) {
			((CallException)th).handleException();
		}
	}
	
	// 어쨌든 끝났을 때
	public void after() {
		System.out.println("집에 갑니다.");
	}
	
	
//	------------------------------------------------------
	
	// <around>
	// pointcut의 전체를 감싸고 있음
	// 따라서 around 안에 핵심 관심사항까지 품고 있음
	public Object around(ProceedingJoinPoint pjt) {
		this.before();
		try {
			// 핵심 관심사항의 호출
			int num = (int)pjt.proceed();
			this.afterReturning(num);
			return num;
		} catch (Throwable e) {
//			e.printStackTrace();
			this.afterThrowing(e);
		} finally {
			this.after();
		}
		return null;
	}
}
