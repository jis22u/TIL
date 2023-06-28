<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<img alt="" src="/test.png">
		<h2>게시글 목록</h2>
		<hr>
		<div>
			<table class="table text-center">
				<thead>
					<tr>	
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody id="boardTbody">
				
				</tbody>
				
			</table>
			
			<form action="search" class="row">
				<div class="col-2">
					<label>검색 기준 : </label>
					<select name="key" class="form-select">
						<option value="none">없음</option>
						<option value="writer">글쓴이</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
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
						<option value="writer">글쓴이</option>
						<option value="title">제목</option>
						<option value="view_cnt">조회수</option>
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
				<a class="btn btn-outline-primary" href="writeform">글 등록</a>
			</div>
		</div>
	</div>
	
	<!-- AJAX 통신을 위해 -->
	<script>
		const xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			//서버에 요청한 데이터 처리가 완료 (에러든 정상이든)
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					console.log(xhr.response) //데이터
					
					const list = JSON.parse(xhr.response)
					let html = "";
					
					for(let board of list){
						html += `
							<tr>
								<td>\${board.id }</td>				
								<td>\${board.title }</td>				
								<td>\${board.writer }</td>				
								<td>\${board.viewCnt }</td>				
								<td>\${board.regDate }</td>				
							</tr>
						`
					}
					
					document.getElementById("boardTbody").innerHTML = html;
				}
			}
		}
		
		
		
		xhr.open("GET", "/api/board"); 	//어떤 페이지에 어떤 방식으로 처리를 할지 쓴다.
		xhr.send(); 					//데이터 요청을 진행
	
	
	</script>
</body>
</html>