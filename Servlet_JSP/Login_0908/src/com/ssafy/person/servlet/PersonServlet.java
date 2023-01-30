// 프론트 컨트롤러 패턴



package com.ssafy.person.servlet;


// 서블릿에는 파라메터 받아서 > 기능 맡기고(personManager에) > 포워드or리다이렉트
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ssafy.person.dto.Person;
import com.ssafy.person.manager.PersonManager;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonManager personManager = PersonManager.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);

		doProcess(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		switch(action) {
			case "login" :
				login(request, response);
				break;
			case "list" :
				list(request, response);
				break;
			case "detail" :
				detail(request, response);
				break;
			case "add" :
				add(request, response);
				break;
			case "update" :
				update(request, response);
				break;
			// 업데이트 작업 자체를 하기 위한
			case "updateForm" :
				updateForm(request, response);
				break;
			// 업데이트 폼으로 이동
			case "delete" :
				delete(request, response);
				break;
		}
		
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals(pw)) {
			request.getSession().setAttribute("id", id);		//세션에 로그인 정보 저장
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 모든 사람목록을 attr 싣고
		Person[] personList = personManager.getPersonList();
		request.setAttribute("pList", personList);
		
		// list.jsp로 포워드
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		// 파라메터 다 받고
		String name = request.getParameter("name");
		int no = Integer.parseInt(request.getParameter("no"));
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		// personManager에 add기능에 던지고
		Person p = new Person(no, name, age, msg);
		personManager.addPerson(p);
		
		// 해당 no에 detail로 리다이렉트
		// VVV
		// 리다이렉트는 응답으로 새로운 요청을 날려
		response.sendRedirect("person?action=detail&no="+no);
		
	}
	
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// no 파라메터를 받아서
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 해당 사람을 personManager에서 조회해서 attr 싣고
		Person p = personManager.getPerson(no);
		request.setAttribute("Person", p);
		
		// detail.jsp로 포워드
		RequestDispatcher disp = request.getRequestDispatcher("detail.jsp");
		disp.forward(request, response);
	}
	
	
	// updateForm에서 온 사람 정보를 수정해주는 기능
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 일단 파라미터 다 받고
		String name = request.getParameter("name");
		int no = Integer.parseInt(request.getParameter("no"));
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		// 그 정보들을 personManager에 update 기능에 던지고
		Person p = new Person(no, name, age, msg);
		personManager.updatePerson(p);
		
		// 해당 no에 detail요청으로 리다이렉트
		// VVV
		response.sendRedirect("person?action=detail&no="+no);
	}
	
	// 업데이트 할 사람을 update에 보냄, 업데이트 작업 공간으로
	public void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// no 파라미터 다 받고
		int no = Integer.parseInt(request.getParameter("no"));
		// 해당 사람을 personManager에서 조회해서 attr 싣고
		Person p = personManager.getPerson(no);
		request.setAttribute("Person", p);
		
		// update.jsp로 포워드
		RequestDispatcher disp = request.getRequestDispatcher("update.jsp");
		disp.forward(request, response);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// no 파라메터 받아서
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 해당 사람 삭제 기능을 personManager의 delete에 던지고
		personManager.deletePerson(no);
		
		// action=list로 리다이렉트
		response.sendRedirect("person?action=list");
		// request.getContextPath() 를 명시하지 않는다면, 현재 경로에 "person?action=list"를 추가하는 것
		// response.sendRedirect(request.getContextPath()+"person?action=list");
	}
	

}