package com.restaurant.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.restaurant.dto.Member;
import com.restaurant.dao.MemberDAO;
import com.restaurant.util.PasswordUtil;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
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
		String name = request.getParameter("name");
		MemberDAO dao = new MemberDAO();
		if (dao.isUserExists(mid)) {
			request.setAttribute("error", "이미 존재하는 아이디입니다");
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("member/joinFail.jsp");
			rd.forward(request, response);
			
			return;
		}
		Member member = new Member();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setName(name);
		int result = dao.insertMember(member);
		if (result > 0) {
			response.sendRedirect("member/joinSuccess.jsp");
		} else {
			request.setAttribute("error", "회원 가입 중에 오류가 발생했습니다");
			jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("member/joinFail.jsp");
			rd.forward(request, response);
		}
	}
}
