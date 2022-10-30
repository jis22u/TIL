 package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component	// Bean 등록
public class Audience {
	// 인터페이스로 느슨한 결합 형태
	private Movie movie;
	
	// 기본 생성자
//	public Audience() {
//	}
	
	
	// 1. 매개변수 있는 생성자
	@Autowired	// 의존성 주입
	public Audience(@Qualifier("comic") Movie movie) {
		this.movie = movie;
		System.out.println("매개변수 생성자");
	}
	
	
	// 2. Setter 함수
//	@Autowired
//	@Qualifier("comic")
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}
	

	// 추가. Setter & Comic.java 클래스에 @Component("movie") 인 상태
	// Comic.java 클래스에 이름을 별도로 지정해주면 오류가 나지 않는다. 단 setter함수의 (set을 뺀) 이름과 동일해야 함
//	@Autowired
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}
	
	
	// 메서드
	public void seeMovie() {
		System.out.println(this.movie.getInfo()+ "를 봅니다.");
	}
	
}