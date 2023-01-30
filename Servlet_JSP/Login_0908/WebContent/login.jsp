<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인하기</h1>
	<form action="person" method="POST">
			<input type="hidden" name="action" value="login"/>
			id : <input type="text" name="id"> <br>
			pw : <input type="text" name="pw"> <br>
			<input type="submit" value="로그인"/>
	</form>
</body>
</html>