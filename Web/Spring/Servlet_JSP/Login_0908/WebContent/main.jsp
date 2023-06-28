<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:choose>
		<c:when test= "${empty id}">
			<a href="login.jsp">로그인하러가기</a>
		</c:when>
		<c:otherwise>
			${id}님 환영합니다.
			<a href="person?action=list">사람목록보기</a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>