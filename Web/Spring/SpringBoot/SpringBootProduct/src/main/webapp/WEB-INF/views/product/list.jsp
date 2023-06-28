<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>상품 목록</h2>
		<hr>
		<div>
			<table class="table text-center">
				<tr>
					<th>번호</th>
					<th>상품명</th>
					<th>가격</th>
					<th>상세정보</th>
				</tr>
				<c:forEach items="${list }" var="product">
					<tr>
						<td>${product.p_id }</td>				
						<td><a href="detail?id=${product.p_id }">${product.p_name }</a></td>				
						<td>${product.p_price }</td>				
						<td>${product.p_description }</td>				
					</tr>
				</c:forEach>
			</table>
			
			<form action="search" class="row">
				<div class="col-2">
					<label>검색 기준 : </label>
					<select name="key" class="form-select">
						<option value="none">없음</option>
						<option value="p_name">상품명</option>
						<option value="p_price">가격</option>
						<option value="p_description">상세 정보</option>
					</select>
				</div>
				<div class="col-5">
					<label>검색어 : </label>
					<input type="text" name="word" class="form-control">
				</div>
				<div class="col-2">
					<label>정렬 기준 : </label>
					<select name="orderBy" class="form-select">
						<option value="none">없음</option>
						<option value="p_name">가격</option>
						<option value="p_price">상품명</option>
					</select>
				</div>
				<div class="col-2">
					<label>정렬 방향 : </label>
					<select name="orderByDir" class="form-select">
						<option value="asc">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</div>
				<div class="col-1">
					<input type="submit" value="검색" class="btn btn-primary">
				</div>
			</form>
			<div class="d-flex justify-content-end">
				<a class="btn btn-outline-primary" href="registform">글 등록</a>
			</div>
		</div>
	</div>
</body>
</html>