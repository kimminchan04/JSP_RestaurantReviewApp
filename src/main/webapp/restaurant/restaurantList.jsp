<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Restaurant" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>맛집 목록</h3>
    <% 
        List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurantList");
        int currentPage = (int) request.getAttribute("page");
        int totalPage = (int) request.getAttribute("totalPage");
        
        if (list != null) {
        	for (Restaurant r : list) {
    %>
                <div>
                    <h3><%=r.getName() %></h3>
                    <p><%=r.getAddress() %></p>
                    <a href="RestaurantDetailController?id=<%=r.getRestaurant_id() %>">상세 내용</a>
                </div>
                <hr>
    <%    		
        	}
        }
    %>
    <div>
        <% if (currentPage > 1) { %>
            <a href="RestaurantListController?page=<%=currentPage - 1 %>">이전</a>
        <% } %>
        <%
            for (int p = 1; p <=totalPage; p++) {
            	if (p == currentPage) {
        %>
                    <strong>[<%=p %>]</strong>
               <% } else { %>
                       <a href="RestaurantListController?page=<%=p %>">[<%=p %>]</a>                   	
        <%        
               } 
            }
        %>
        <% if (currentPage < totalPage) { %>
            <a href="RestaurantListController?page=<%=currentPage + 1 %>">다음</a>
        <% } %>
    </div>
</body>
</html>