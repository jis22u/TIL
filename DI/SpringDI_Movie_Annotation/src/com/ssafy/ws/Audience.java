package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component	// Bean으로 등록
public class Audience {
	// 인터페이스로 느슨한 결합 형태
	private Movie movie;
	
	// 기본 생성자
//	public Audience() {
//	}
	
	
	// 매개변수 있는 생성자
	@Autowired	// 의존성 주입
	public Audience(@Qualifier("comic") Movie movie) {
		this.movie = movie;
		System.out.println("매개변수 생성자");
	}
	
	
	// Setter
//	@Autowired
//	@Qualifier("comic")
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}
	
	
	// 메서드
	public void seeMovie() {
		System.out.println(this.movie.getInfo()+ "를 봅니다.");
	}
	
}