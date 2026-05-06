package com.restaurant.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.restaurant.dao.RestaurantDAO;
import com.restaurant.dto.Restaurant;

/**
 * Servlet implementation class RestaurantListController
 */
@WebServlet("/RestaurantListController")
public class RestaurantListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageParam = request.getParameter("page");
		int page = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
		int pageSize = 6;
		int start = (page - 1) * pageSize;
		RestaurantDAO dao = new RestaurantDAO();
		List<Restaurant> list = dao.getRestaurantList(start, pageSize);
		int totalCount = dao.getTotalCount();
		int totalPage = (int) Math.ceil((double) totalCount / pageSize);
		request.setAttribute("restaurantList", list);
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		request.getRequestDispatcher("/restaurant/restaurantList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
