package com.ssafy.fit.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssafy.fit.model.Member;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.MemberDaoImpl;

public class MainUi {
	Scanner sc = new Scanner(System.in);
	public void service() throws FileNotFoundException {
		int sel;
		do {
			VideoUi vui = VideoUi.getInstance();
			MemberUi mui = MemberUi.getInstance();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("자바로 구현하는 SSAFIT");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원목록");
			System.out.println("3. 영상정보");
			System.out.println("0. 종료");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			
			sel = sc.nextInt();
			if(sel==1) {	
				mui.registMember();
			} else if(sel==2) {
				mui.listMember();
			} else if(sel==3) {
				vui.service();
			} else if(sel==0) {
				Gson gson = new Gson();
				String memberList = gson.toJson(MemberDaoImpl.getInstance().getList());
				
				File file = new File("..\\java_pjt\\src\\com\\ssafy\\fit\\model\\dao\\member.json");
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(memberList);
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.exit();
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		
		//sel이 1 또는 2 또는 0이 아니면 반복
		}while(sel==1||sel==2||sel!=0);
	} //service
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	} //exit
	
} //end class
