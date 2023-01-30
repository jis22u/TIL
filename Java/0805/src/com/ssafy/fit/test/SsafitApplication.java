package com.ssafy.fit.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssafy.fit.model.Member;
import com.ssafy.fit.model.dao.MemberDaoImpl;
import com.ssafy.fit.ui.MainUi;

public class SsafitApplication {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		MainUi mainui= new MainUi();
		
		Gson gson = new Gson();
		Reader reader = new FileReader("..\\0805\\src\\com\\ssafy\\fit\\model\\dao\\member.json");
		List<Member> tmpList = new ArrayList<Member>();
		tmpList = gson.fromJson(reader,  new TypeToken<List<Member>>(){}.getType());
		for(Member m : tmpList) {
			MemberDaoImpl.getInstance().add(m);
		}
		mainui.service();	
	}
}
