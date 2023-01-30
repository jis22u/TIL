package com.SD08.fit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SD08.fit.model.dao.ReviewDaoImpl;
import com.SD08.fit.model.dao.VideoDaoImpl;
import com.SD08.fit.model.dto.Review;
import com.SD08.fit.model.dto.Video;

@WebServlet("/MainServlet")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDaoImpl vmn = VideoDaoImpl.getInstance();
	ReviewDaoImpl rmn = ReviewDaoImpl.getInstance();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "home":
			doHome(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "review_write":
			doWrite(request, response);
			break;
		case "review_form":
			doReviewForm(request, response);
			break;
		case "regist":
			doRegist(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		}

	}

	// 구현하기!!!!
	private void doRemove(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");

	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + " " + pw);
		String user_id = (String) session.getAttribute("user_id");
		String user_pw = (String) session.getAttribute("user_pw");

		boolean check = false;
		if (id.equals(user_id) && pw.equals(user_pw)) {
			check = true;
			session.setAttribute("login_check", check);
			response.sendRedirect("MainServlet?action=home");
		} else {
			session.setAttribute("login_check", check);
			response.sendRedirect("regist.jsp");
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		session.setAttribute("user_id", id);
		session.setAttribute("user_pw", pw);

		response.sendRedirect("MainServlet?action=home");
	}

	private void doReviewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoId = request.getParameter("id"); // 해당 영상 id
		List<Review> reviews = rmn.getReviewList(videoId); // 해당 영상의 리뷰 배열
		request.setAttribute("review_list", reviews); // 리뷰 배열을 req저장
		request.setAttribute("videoid", videoId); // 해당 영상 id를 req저장
		request.getRequestDispatcher("review.jsp").forward(request, response); // 포워드
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String videoId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Review new_review = new Review(videoId, title, "누구", content);
		rmn.addReview(new_review);

		response.sendRedirect("MainServlet?action=detail&id="+videoId);

		// 실험 1. 새로고침을 하면 리뷰가 중복으로 등록된다.
		//		   이는 포워드 방식으로 요청을 보냈기 때문이다.
		//		   포워드 방식은 기존의 요청을 그대로 유지한채 페이지 이동을 한다. 
		//        따라서 기존에 리뷰를 등록하려는 요청도 계속해서 전달되는 것
//		Video selectOne = vmn.selectVideo(videoId);
//		if (selectOne == null)
//			System.out.println("영상이 없습니다.");
//		else {
//			List<Review> new_list = rmn.getReviewList(videoId);
//			request.setAttribute("review_list", new_list);
//	
//			request.setAttribute("selectVideo", selectOne);
//			request.getRequestDispatcher("detail.jsp").forward(request, response);
//		}
		
		// 실험 2. 그렇다면 리다이렉트로 보내면 어떻게 될까
		//        리다이렉트는 새로운 요청을 만들어 페이지를 이동하기 때문에 기존의 요청들이 모두 없어진다.
//		response.sendRedirect("detail.jsp");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String videoId = request.getParameter("id");
		Video selectOne = vmn.selectVideo(videoId);
		if (selectOne == null)
			System.out.println("영상이 없습니다.");
		else {
			List<Review> new_list = rmn.getReviewList(videoId);
			request.setAttribute("review_list", new_list);

			request.setAttribute("selectVideo", selectOne);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}

	private void doHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("videoList", vmn.selectInterestViewFitVideo());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
