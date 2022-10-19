package com.ssafy.mvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.MyService;

// Spring MVC 흐름 : 강의 Spring Web MVC2(2:18:29)
// @Component - (1) @Controller (2) @Service (3) @Repository
@Controller
public class MyController {

	private MyService myService;

	/**
	 * DI와 IoC 적용
	 * 
	 * @param myService
	 */
	@Autowired
	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	/**
	 * Controller가 Dispatcher Servlet에게 ModelAndView 객체를 전달
	 * 
	 * @RequestMapping()은 URL을 클래스 또는 특정 핸들러(메서드)에 매핑시킨다. 일반적으로 클래스에
	 *                    작성하는 @RequestMapping은 요청 경로 혹은 요청 패턴에 매칭 메서드 Annotation은
	 *                    요청방식(GET, POST) 등으로 범위를 좁혀 준다.
	 * @return ModelAndView
	 */
	@RequestMapping("home")
	public ModelAndView handler1() {
		ModelAndView mav = new ModelAndView();

		System.out.println("home 이라는 요청이 왔다.");
		myService.doSomething();

		// Model 만듦
		// request.setAttribute 와 동일
		mav.addObject("msg", "Hello World Welcome to SSAFY");

		// View 만듦
		// request.디스패처 한 것과 동일
		mav.setViewName("home");

		return mav;
	}

	@RequestMapping("test11")
	public String handler3(HttpServletRequest request, Locale locale, Model model) {
		model.addAttribute("locale_name", locale.getDisplayName());
		model.addAttribute("url", request.getRequestURL());
		return "test11";
	}
	
	@RequestMapping("test22/{id}") 
	public String handler4(@PathVariable int id, String name, Model model) {
		model.addAttribute("path_var", id);
		model.addAttribute("name", name);
		return "test22";
	}
	
	
	
	/**
	 * required = true 설정을 해주면 요청 피라미터에 해당 속성이 없을 경우 400에러(잘못된 요청) 발생
	 * @param name
	 * @param id
	 * @param model
	 * @return "test33" (ViewName)
	 */
	@RequestMapping("test33")
	public String handler4_1(@RequestParam(value="name", required=true) String name,
							 @RequestParam(value="id", defaultValue = "1") int id,
							 Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test33";
	}
	
	
//	------------------------------------------------------------------

//	[get / post] 각각에만 동작하는 RequestMappering 방식
//	@GetMapping과 @PostMapping
//  리턴하는 것은 ViewName을 리턴하는 것
	
	/**
	 * 문자열 자체가 viewname이 된다
	 * @return String
	 */
	@GetMapping("test1")
	public String test1() {
		return "test1";
	}

	
	
	/**
	 * 
	 * model 객체에 담아서 보냄
	 * @return String
	 */
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "만능 보따리 model 객체에 담아서 보내겠다");
		return "test2";
	}

	// Parmeter를 받고 싶다.
	// 변수명이 파라미터의 키값이 된다.
	// 파라미터의 값이 들어오지 않으면 null
	// 기초자료형을 사용할 떄 Null이라고 하는 것은 말도 안되는 것

	@GetMapping("test3")
	public String test3(Model model, String id, String pw, @RequestParam(value = "age", defaultValue = "1") int age) {
		model.addAttribute("myid", id);
		model.addAttribute("mypw", pw);                                 

		System.out.println(age);
		return "test3";                       
	}

	// 적절한 DTO를 준비를 해놓으니 Spring이 알아서 User 클래스의 필드에 대입
	@PostMapping("test4")
	public String test4(Model model, User user) {
		System.out.println(user);

		return "test4";
	}
	
	
	
	
	/**
	 * 여기서의 "redirect"는 서블릿에서의 response.sendRedirect()와 다르다.
	 * url 뒤에 'test8?message=test8'이 붙어 변경된다.
	 * 이는 response.sendRedirect()처럼 url이 변경되는 것은 동일하지만
	 * 기존 요청에 들어있는 정보들이 그대로 살아남은 채 페이지 이동이 된 것이다.
	 * (그랬기 때문에 url 뒤에 쿼리 스트링이 붙어 있는 것)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	 * @param model
	 * @return String
	 */
	@RequestMapping("test9")
	public String handler9(Model model) {
		model.addAttribute("message", "test8");
		return "redirect:test8";
	}
	
	
	@RequestMapping("test8")
	public String handler8() {
		return "test9";
	}
	
	

}
