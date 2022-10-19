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
	${Person.no} <br>
	${Person.name} <br>
	${Person.age} <br>
	${Person.msg} <br>
	<input type="button" value="수정" onclick="location.href='person?action=updateForm&no=${Person.no}'">
	<input type="button" value="삭제" onclick="location.href='person?action=delete&no=${Person.no}'">
	<input type="button" value="목록" onclick="location.href='person?action=list'">


</body>
</html>