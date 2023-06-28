<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.SD08.fit.model.dto.*" %>
<%@ page import = "com.SD08.fit.model.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${selectVideo.title}</h1>
	
	<iframe src="${selectVideo.url}">
    	<p></p>
	</iframe>
	
	<button onclick="location.href='MainServlet?action=home'">메인으로</button>
	<button onclick="location.href='MainServlet?action=review_form&id=${selectVideo.id}'">리뷰등록</button>


	<div>
		<c:if test ="${review_list.size() != 0 }" >
			<c:forEach var="review" items="${review_list}">
				
				${review.content }<br>
				<form action="MainServlet" method="POST">
					<input type="hidden" name="action" value="delete">
					<input type="hidden" name="video_id" value="${selectVideo.id}">
					
					<input type="hidden" name="title" value="${review.title}">
					<button>리뷰삭제</button>
				</form>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>