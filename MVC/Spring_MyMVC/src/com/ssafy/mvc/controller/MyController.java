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
	 * @param myService
	 */
	@Autowired
	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	
	/**
	 * Controller가 Dispatcher Servlet에게 ModelAndView 객체를 전달
	 * @RequestMapping()은 URL을 클래스 또는 특정 핸들러(메서드)에 매핑시킨다. 
	 * 					일반적으로 클래스에 작성하는 @RequestMapping은 요청 경로 혹은 요청 패턴에 매칭 
	 * 					메서드 Annotation은 요청방식(GET, POST) 등으로 범위를 좁혀 준다.
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
	
	
	/**
	 * @PathVariable : URI 템플릿 변수에 대한 액세스.
	 * 				 : 예를 들어, http://localhost:8080/pjt02/hello/test2/12?name=kang
	 * 				 : 에서 '12'에 대한 엑세스
	 * @param id
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("test22/{id}") 
	public String handler4(@PathVariable int id, String name, Model model) {
		model.addAttribute("path_var", id);
		model.addAttribute("name", name);
		return "test22";
	}
	
	
	/**
	 * @RequestParam : 예를 들어, http://localhost:8080/pjt02/hello/test2/12?name=kang
	 * 				 : 에서 'name=kang'에 대한 엑세스
	 * required : true 설정을 해주면 요청 피라미터에 해당 속성이 없을 경우 400에러(잘못된 요청) 발생
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
	 * model 객체에 담아서 보냄
	 * @return String
	 */
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "만능 보따리 model 객체에 담아서 보내겠다");
		return "test2";
	}

	
	/**
	 * <Parmeter를 받는 경우>
	 * 변수명이 파라미터의 키값이 된다.
	 * 값이 들어오지 않으면 null이 되는데,
	 *  1) String과 같은 참조자료형은 파라미터의 값이 들어오지 않으면 null. 
	 * 	     이는 jstl 문법에 의해 예외가 뜨진 않고 빈칸으로 표시된다.
	 *  2) 반면, 기초자료형이 null이라고 하는 것은 예외상황이다.(500에러 뜸)
	 * 	   value = "age", defaultValue = "1"와 같이 null예외를 방지한다.
	 * @RequestParam : multipart 파일을 포함하여 요청 파라미터에 엑세스
	 * defaultValue : 요청 파라미터에 해당 속성이 없을 경우 기본값 지정
	 */
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
	 * 여기서의 "redirect"는 서블릿에서의 response.sendRedirect()와 같다.
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
