package com.restaurant.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.restaurant.dto.Member;
import com.restaurant.dto.Restaurant;
import com.restaurant.dto.Review;
import com.restaurant.dao.ReviewDAO;


/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/ReviewController")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
	    if (s == null || s.getAttribute("loginUser") == null) {
	        response.sendRedirect(request.getContextPath() + "/member/login.jsp");
	            
	        return;
	    }
	    Member m = (Member) s.getAttribute("loginUser");
	    int restaurant_id = Integer.parseInt(request.getParameter("restaurant_id"));
	    int score = Integer.parseInt(request.getParameter("score"));
	    String description = request.getParameter("description");
	    Review review = new Review();
	    review.setRestaurant_id(restaurant_id);
	    review.setMember_id(m.getMember_id());
	    review.setScore(score);
	    review.setDescription(description);
	    ReviewDAO dao = new ReviewDAO();
	    dao.insertReview(review);
        response.sendRedirect("MyReviewListController?member_id=" + m.getMember_id());
	}
}
