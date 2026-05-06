<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Restaurant" %>
<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>
<% List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurantList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"/>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
<style> 
    #map {
        width: 100%;
        height: 400px;
        margin-bottom: 30px; 
    }
    .restaurant {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
    }
</style>
</head>
<body>
    <h3>Restaurant List</h3>
    <div id="map"></div>
    <% for (Restaurant r : list) {  %>
        <div class="restaurant">
            <h4><%=r.getName() %></h4>
            <p>Address: <%=r.getAddress() %></p>
            <p>Description: <%=r.getDescription() %></p>
            <a href="RestaurantDetailController?id=<%=r.getRestaurant_id() %>">상세 내용</a>
        </div>
    <% } %>
    <script>
        <% if (!list.isEmpty()) { %>
            const map = L.map("map").setView([<%=list.get(0).getLat() %>, <%=list.get(0).getLng() %>], 13);
        <% } else { %>
            const map = L.map("map").setView([37.5665, 126.9780], 12);
        <% } %>
        L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {maxZoom: 19, attribution: "&copy; OpenStreetMap contributors"}).addTo(map);
        <% for (Restaurant r : list) { %>
            L.marker([<%=r.getLat() %>, <%=r.getLng() %>]).addTo(map).bindPopup(
            	"<b><%=r.getName() %></b><br>" + 
            	"<a href='RestaurantDetailController?id=<%=r.getRestaurant_id() %>'>상세 내용</a>"
            );
        <% } %>
    </script>
</body>
</html>