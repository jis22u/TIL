<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>파일 업로드하기</h1>
	
	<!-- 서버에 보낼 요청 만들기 : POST 방식으로 전달 -->
	<!-- 파일은 주로 용량 제한이 없는 post 방식으로 보낸다. -->
	<form action="upload" method="post" enctype="multipart/form-data">
		<!-- name 속성 : 서버 측에서 요청이 들어왔을 때 어떤 데이터인지 구분하기 위해 필요하다-->
		<input type="file" name="upload_file" multiple="multiple">
		<input type="submit">
	</form>
</body>
</html>