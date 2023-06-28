<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.SD08.fit.model.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
</head>
<body>
	
	<div>
		<form action="MainServlet" method="POST">
			<input type="hidden" name="id" value="${videoid}">
			<input type="text" name="title"  placeholder="제목을 입력하세요">
			<input type="hidden" name="action" value="review_write">			
			<input type="textarea"   name="content" placeholder="리뷰를 등록하세요">
			<button> 리뷰등록 </button>
		</form>
	</div>
	

</body>
</html>