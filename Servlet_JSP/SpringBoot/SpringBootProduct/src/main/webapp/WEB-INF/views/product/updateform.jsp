<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>상품 수정</h2>
		<form action="update" method="POST">
			<input type="hidden" name="p_id" value="${product.p_id }">
			<div class="mb-3">
				<label for="name" class="form-label">상품명</label>
				<input type="text"  class="form-control" id="name" name="p_name" readonly value="${product.p_name }">
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">상품가격</label>
				<input type="number"  class="form-control" id="price" name="p_price" value="${product.p_price }">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">상품 상세 정보</label>
				<textarea rows="10"  class="form-control" id="description" name="p_description">${product.p_description }</textarea>
			</div>
			<button class="btn btn-primary">수정</button>
		</form>
	</div>
</body>
</html>