<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
    <%@ include file="../header.jsp" %>
    <div class="container mt-4" style="max-width: 480px;">
        <h3>로그인</h3>
        <form action="${pageContext.request.contextPath}/LoginController" method="post">
            <div class="mb-3">
                <label class="form-label">아이디</label>
                <input type="text" name="mid" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="from-label">비밀번호</label>
                <input type="password" name="mpw" class="form-control" required>
            </div>
            <button class="btn btn-primary w-100">로그인</button>
        </form>
        <p>아직 회원이 아니시면 가입해 주세요 <a href="joinForm.jsp">회원 가입</a></p>
    </div>
</html>