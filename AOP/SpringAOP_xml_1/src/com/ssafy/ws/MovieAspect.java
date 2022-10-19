package com.ssafy.ws;

public class MovieAspect {
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
	public void afterReturning(int num) {
		System.out.println("영화가 끝나고 나옵니다.");
	}
	public void afterThrowing(Throwable th) {
		System.out.println("전화를 받습니다.");
		if( th instanceof CallException) {
			((CallException)th).handleException();
		}
	}
	public void after() {
		System.out.println("집에 갑니다.");
	}
}
