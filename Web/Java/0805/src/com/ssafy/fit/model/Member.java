package com.ssafy.fit.model;

public class Member {
	private String id;
	private String name;
	private int password;		//6자리 숫자
	private String email;
	private int reviewCnt = 0;
	
	public Member(String id, String name, int password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReviewcnt() {
		return reviewCnt;
	}
	public void setReviewcnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	
	
	@Override
	public String toString() {
		return "[아이디= " + id + ", 이름= " + name + ", 비밀번호= " + password + ", email= " + email+", 등록리뷰= "+reviewCnt+"]";
	}


}
