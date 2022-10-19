<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.SD08.fit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT</title>
</head>
<body>
	<h1>SSAFIT</h1>
	
	<c:choose>
		<c:when test="${login_check eq true}">
			${user_id}님 환영합니다.
		</c:when>
		<c:otherwise>
			<a href="regist.jsp">회원가입</a>
			<a href="login.jsp">로그인</a>
		</c:otherwise>
	</c:choose>
	
	
	<!-- 덜 구현함 -->
	<h3>조회순</h3>
	
	<c:forEach var="v" items="${videoList}">
	<c:set var = "pic" value = "https://img.youtube.com/vi/${v.id}/0.jpg"/>	
		<a href = "MainServlet?action=detail&id=${v.id}"><img src=${pic} style=" width:100px; height:100px"></a>
		
	</c:forEach>

	
</body>
</html>