package com.kjlink.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Category;
import com.kjlink.privilege.service.CategoryService;
import com.kjlink.privilege.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class WishList
 */
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WishListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> guideList = new ArrayList<Category>();
		guideList = categoryService.showGuide();

		if (guideList != null && guideList.size() != 0) {
			
			request.setAttribute("guideList", guideList);
			request.getRequestDispatcher("/header.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
