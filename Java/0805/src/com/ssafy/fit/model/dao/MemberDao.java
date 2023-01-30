package com.ssafy.fit.model.dao;


import com.ssafy.fit.model.Member;

public interface MemberDao {
	void add(Member member);
	Member[] getList();
	void cntplus(Member member);
}
