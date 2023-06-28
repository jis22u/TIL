<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세보기</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>상품 상세보기</h2>
		<hr>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${product.p_name }</h5>
				<div class="d-flex justify-content-between">
					<div class="card-subtitle mb-2 text-muted">${product.p_name }</div>
					<div class="card-subtitle mb-2 text-muted">${product.p_price }</div>
				</div>
				<p class="card-text">${product.p_description }</p>
				<div>
					<a href="updateform?id=${product.p_id }" class="btn btn-success">수정</a>
					<a href="delete?id=${product.p_id }" class="btn btn-info">삭제</a>
					<a href="list" class="btn btn-warning">목록</a>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>