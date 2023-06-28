<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>상품 등록</h2>
		<form action="regist" method="POST">
			<div class="mb-3">
				<label for="name" class="form-label">상품 이름</label>
				<input type="text" class="form-control" id="name" name="p_name">
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">가격</label>
				<input type="number" class="form-control" id="price" name="p_price">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">상품 상세 정보</label>
				<textarea rows="10" class="form-control" id="description" name="p_description"></textarea>
			</div>
			<button class="btn btn-primary">등록</button>
		</form>
	</div>
</body>
</html>