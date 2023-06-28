package com.sd08.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd08.mvc.model.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("a")
	public String a() {
		// 로그인 시도 시 session을 검사해서 해당 아이디와 비번이 있는지 검사
		// 로그인 성공 시 , return "a"
		// 로그인 실패 시, return "redirect:/" (요청을 무산시키고 다른 페이지로 이동시키기)
		// 이러한 로그인 승인 과정은 intercepter가 담당한다.
		return "a";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, String id, String pw) {
		// @RequestParam으로 이름을 맞춰버릴 수도 있다..? (인터셉터강의 13:43)
		boolean result = loginService.login(id, pw);
		
		if(result) {
			//로그인 성공 시 세션에 정보 담고 페이지 이동시키기
			session.setAttribute("loginUser", id);
			return "redirect:/";
		} else {
			// 로그인 실패 시 지금까지의 요청 무산시키고 다시 로그인 페이지로 이동시키기
			return "redirect:/login";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
