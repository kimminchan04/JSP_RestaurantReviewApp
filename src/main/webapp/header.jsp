<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.Member" %>
<% Member loginUser = (Member) session.getAttribute("loginUser"); %>
<style>
    .orange-navbar {
        background-color: #ff9800;
    }
    .orange-navbar .nav-link {
        transition: background-color 0.25s ease, color 0.25s ease;
        padding: 6px 12px;
    }
    .orange-navbar .nav-link:hover {
        background-color: #e65100;
        color: #ffffff;
    }
    .text-orange {
        color: #ff9800;
    }
    .orange-navbar .btn-light:hover {
        background-color: #ffe0b2;
        color: #e65100;
    }
    .navbar-toggler-icon {
        filter: invert(1);
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<header>
    <nav class="navbar navbar-expand-lg orange-navbar">
        <div class="container">
            <a class="navbar-brand fw-bold text-white">RestaurantList</a>
        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#orangeNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="orangeNav">
            <ul class="navbar-nav ms-auto align-item-center gap-2">
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/GetRestaurantByScoreController">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/RestaurantListController">Restaurant List</a>
                </li>
                <% if (loginUser != null) { %>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/MyReviewListController">My Review List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-semibold" href="mypage.jsp">My Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/LogoutController">Logout</a>
                    </li>                    
                <% } else { %>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/member/login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-semibold" href="${pageContext.request.contextPath}/member/joinForm.jsp">Join</a>
                    </li>
                <% } %>
            </ul>
        </div>
    </nav>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
