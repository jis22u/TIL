<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action = "MainServlet" method = "POST">
		<input type="hidden" name="action" value="login">
			ID : <input type = "text" name = "id">
			PW : <input type = "password" name = "pw">
		<input type = "submit" value = "로그인">
	</form>
</body>
</html>