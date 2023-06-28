package com.ssafy.ws;

public class Audience {
	private Movie movie;
	
	// 의존성 주입 2. 설정자 주입
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	// 기본 생성자
	public Audience() {
	}
	
	
	// 메서드
	public void seeMovie() {
		System.out.println(this.movie.getInfo()+ "를 봅니다.");
	}
	
}

