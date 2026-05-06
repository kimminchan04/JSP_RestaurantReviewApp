package com.restaurant.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.restaurant.dao.ReviewDAO;
import com.restaurant.dto.Member;
import com.restaurant.dto.Review;
import java.util.*;


/**
 * Servlet implementation class MyReviewListController
 */
@WebServlet("/MyReviewListController")
public class MyReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		if (s == null || s.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/member/login.jsp");
			
			return;
		}
		Member m = (Member) s.getAttribute("loginUser");
		ReviewDAO dao = new ReviewDAO();
		List<Review> reviewList = dao.getReviewByMember(m.getMember_id());
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/review/myReviewList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
