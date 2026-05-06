<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Review" %>
<%@ page import="com.restaurant.dto.Restaurant" %>
<%@ page import="com.restaurant.dao.RestaurantDAO" %>
<%@ page import="java.util.List" %>
<% List<Review> reviewList = (List<Review>) request.getAttribute("reviewList"); %>
<% RestaurantDAO restaurantDAO = new RestaurantDAO(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Review List</title>
<style>
    .review-box {
        border-bottom: 1px solid #ddd;
        padding: 15px 0;
    }
</style>
</head>
<body>
    <h3>My Review List</h3>
    <% if (reviewList == null) { %>
        <p>작성한 리뷰가 없습니다</p>
    <% 
        } else { 
            for (Review r : reviewList) {    
    %>
    <%
                Restaurant restaurant = restaurantDAO.getRestaurantById(r.getRestaurant_id());
    %>
        <div class="review-box">
            <p>식당 이름: <%=restaurant.getName() %></p>
            <p>평점: <%=r.getScore() %></p>
            <p><%= r.getDescription() %></p>
            <a href="RestaurantDetailController?id=<%=r.getRestaurant_id() %>">view more</a>
        </div>
    <% 
            } 
        } 
    %>
    <a href="RestaurantListController">Restaurant List</a>
</body>
</html>