package com.sd08.mvc.model.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean login(String id, String pw) {
		// 실제론 DAO와 소통 후에
		// 아이디와 패스워드가 같으면 로그인 성공
		return id.equals(pw);
	}
}
