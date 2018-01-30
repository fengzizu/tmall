package com.kjlink.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.service.CategoryService;
import com.kjlink.privilege.service.impl.CategoryServiceImpl;

public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 实现添加商品类别
	public AddCategory() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CategoryService cs = new CategoryServiceImpl();
		// 首先获取一级商品的类别
		String oneGrade = request.getParameter("oneGrade");
		System.out.println(oneGrade+".....oneGrade");
		// 获取商品的类别
		String twoGrade = request.getParameter("twoGrade");
		System.out.println(twoGrade+".....twoGrade");

		String[] array2 = twoGrade.trim().split("-");
		// 调用业务层
		int i = cs.addCategory(oneGrade, array2);
		System.out.println("添加商品的返回值"+i);
		System.out.println(Arrays.toString(array2)+"asgfaosfgaoagh");
		if (i == 1) {
			request.setAttribute("msg", "添加商品成功！");
			request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
		} else {
			System.out.println("添加分类失败");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
