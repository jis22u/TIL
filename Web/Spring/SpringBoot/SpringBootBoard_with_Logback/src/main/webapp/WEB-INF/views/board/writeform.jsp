<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>글 작성</h2>
		<form action="write" method="POST">
			<div class="mb-3">
				<label for="title" class="form-label">글제목</label>
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">글쓴이</label>
				<input type="text" class="form-control" id="writer" name="writer">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">글내용</label>
				<textarea rows="10" class="form-control" id="content" name="content"></textarea>
			</div>
			<button class="btn btn-primary">등록</button>
		</form>
	</div>
</body>
</html>