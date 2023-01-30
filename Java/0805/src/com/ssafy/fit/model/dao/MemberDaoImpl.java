package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.Member;

public class MemberDaoImpl implements MemberDao {

	private List<Member> memberList = new ArrayList<Member>();
	
	private static MemberDao instance = new MemberDaoImpl();
	
	private MemberDaoImpl(){
		
	}
	
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	@Override
	public void add(Member member) {
		memberList.add(member);
	}

	@Override
	public Member[] getList() {
		Member[] member = new Member[memberList.size()];
		return memberList.toArray(member);
	}
	
	@Override
	public void cntplus(Member member) {
		member.setReviewcnt(member.getReviewcnt()+1);
	}
	
} //end class
