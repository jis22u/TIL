<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action = "MainServlet" method = "POST">
		<input type="hidden" name="action" value="regist">
			ID : <input type = "text" name = "id">
			PW : <input type = "password" name = "pw">
			<input type = "submit" value = "회원가입">
	</form>
</body>
</html>