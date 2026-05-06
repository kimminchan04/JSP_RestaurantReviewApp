package com.restaurant.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.restaurant.dao.MemberDAO;
import com.restaurant.dto.Member;
import com.restaurant.util.PasswordUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	    request.setCharacterEncoding("UTF-8");
	    String mid = request.getParameter("mid");
	    String mpw = PasswordUtil.hashPassword(request.getParameter("mpw"));
	    MemberDAO dao = new MemberDAO();
	    Member member = dao.login(mid, mpw);
	    if (member != null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser", member);
	    	response.sendRedirect("index.jsp");
	    } else {
	    	request.setAttribute("error", "아이디 또는 비밀번호가 틀렸습니다");
	    	RequestDispatcher rd = request.getRequestDispatcher("member/login.jsp");
	    	rd.forward(request, response);
	    }
	}
}
