package com.ssafy.fit.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ssafy.fit.model.Member;
import com.ssafy.fit.model.dao.MemberDao;
import com.ssafy.fit.model.dao.MemberDaoImpl;


public class MemberUi {
	Scanner sc = new Scanner(System.in);
	private MemberDao memberDao = MemberDaoImpl.getInstance();
	private static MemberUi instance = new MemberUi();
	
	private MemberUi() {
	}
	
	public static MemberUi getInstance() {
		return instance;
	}
	
	public void registMember() throws FileNotFoundException {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.print("아이디를 입력하세요.\n>>> ");
		String id= sc.nextLine();
		System.out.print("이름을 입력하세요.\n>>> ");
		String name = sc.nextLine();
		System.out.print("비밀번호를 6자리 숫자 이상으로 입력하세요.\n>>> ");
		int password = sc.nextInt();
		while(password<100000) {
	            System.out.println("잘못된 비밀번호입니다. 다시 입력해주세요.\n>>>");
	            password = sc.nextInt();
	    }
		sc.nextLine();
		System.out.print("이메일을 입력하세요.\n>>> ");
		String email = sc.nextLine();
		
		Member member = new Member(id, name, password, email);
		
		memberDao.add(member);
		MainUi mainui= new MainUi();
		mainui.service();
	}
	
	public void listMember() {
		System.out.println("--------------------------------------------------------------------------------");
		Member[] memberArr = memberDao.getList();
		for(Member m : memberArr) {
			System.out.println(m);
		}
	}
	
}
