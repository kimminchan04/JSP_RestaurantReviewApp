<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Member" %>
<%
    Object loginUser = session.getAttribute("loginUser");
    if (loginUser == null) {
    	response.sendRedirect(request.getContextPath() + "/member/login.jsp");
    
    	return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>리뷰 작성</h2>
    <form action="${pageContext.request.contextPath}/ReviewController" method="post">
        <input type="hidden" name="restaurant_id" value="${param.restaurant_id}">
        <div>
            <label>평점: </label>
            <select name="score" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>               
            </select>
        </div>
        <div>
            <label>리뷰 내용: </label>
            <textarea name="description" rows="5" cols="40" required></textarea>
            <button type="submit">등록</button>
        </div>
    </form>
</body>
</html>