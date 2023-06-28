<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>

	<!-- 결과1. 톰캣 서버에 저장된 파일 불러오기 -->
	<!-- context root를 변수에 저장해놓고 경로 설정해보기 -->
	<!-- <a href="/mvc/file/${fileName }">${fileName }</a> -->
	 
	
	<!-- 결과2. 파일 다운로드 -->
	<a href="download?fileName=${fileName }">${fileName }</a> 
</body>
</html>