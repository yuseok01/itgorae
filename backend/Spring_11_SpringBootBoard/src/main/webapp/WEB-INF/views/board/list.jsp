<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<%@ include file="../common/bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="../common/header.jsp" %>
		<h2>게시글 목록</h2>
		<hr>
		
		<%@ include file="../common/searchForm.jsp" %>
		
		<div>
			<table class="table text-center">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓰니</th>
					<th>조회수</th>
					<th>등록날짜</th>
				</tr>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.id}</td>
						<td><a href="detail?id=${board.id}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.viewCnt}</td>
						<td>${board.regDate}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="d-flex justify-content-end">
				<a class="btn btn-outline-primary" href="writeform">글등록</a>
			</div>
		</div>

	</div>
</body>
</html>