package com.sd08.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor{
	
	
	/**
	 * HandlerMapping이 되기 이전에
	 * @return boolean타입으로 true일 경우, 계속 실행 false일 경우, 계속 실행하지 않겠다
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 해당 요청 영역 내의 세션 불러오기
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			// @GetMapping("login")에 매핑된다
			// get방식으로 요청보내는 것이므로
			response.sendRedirect("login");
			return false;
		} else {
			return true;
		}
	}
}
