<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Restaurant" %>
<%@ page import="com.restaurant.dto.Review" %>
<%@ page import="java.util.*" %>
<% 
    Restaurant dto = (Restaurant) request.getAttribute("dto"); 
    List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=dto.getName() %></title>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"/>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
<style>
    #map {
        width: 100%;
        height: 400px;
        margin-top: 15px;
        border-radius: 10px;
    }
    .review-box {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
    }
</style>
</head>
<body>
    <h3><%=dto.getName() %></h3>
    <p>주소: <%=dto.getAddress() %></p>
    <hr>
    <h3>위치</h3>
    <div id="map"></div>
    <script>
        const lat = <%=dto.getLat() %>;
        const lng = <%=dto.getLng() %>;
        const map = L.map("map").setView([lat, lng], 16);
        L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
            maxZoom: 19,
            attribution: "&copy; OpenStreetMap contributors"
        }).addTo(map);
        L.marker([lat, lng]).addTo(map).bindPopup("<b><%=dto.getName() %></b><br><%=dto.getAddress() %>").openPopup();
    </script>
    <hr>
    <h3>리뷰</h3>
    <% if (reviewList == null || reviewList.isEmpty()) { %>
        <p>등록된 리뷰가 없습니다</p>
    <%
        } else { 
        	for (Review r : reviewList) {
    %>
                <div class="review-box">
                    <p>작성자: <%=r.getMember_id() %></p>
                    <p>평점: <%=r.getScore() %> / 5.0</p>
                    <p><%= r.getDescription() %></p>
                </div>
    <%     		
        	}
        }
    %>
    <br>
    <a href="${pageContext.request.contextPath}/review/reviewForm.jsp?restaurant_id=<%=dto.getRestaurant_id() %>">
        <button>리뷰 작성</button>
    </a>
    <br>
    <br>
    <a href="RestaurantListController">목록 이동</a>
</body>
</html>