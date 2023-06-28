package com.ssafy.ws;

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
}
