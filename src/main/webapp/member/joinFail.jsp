<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dream Tour</title>
</head>
<body>
	<div>
		<h1>회원 가입 오류</h1>
		<% String error = (String) request.getAttribute("error"); %>
		<p>Error: <%= error %></p>
		<a href="${pageContext.request.contextPath}/member/joinForm.jsp">회원 가입</a>
	</div>
</body>
</html>