package com.kjlink.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Product;
import com.kjlink.privilege.service.ProductService;
import com.kjlink.privilege.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer purchasePrice = Integer.parseInt(request.getParameter("purchasePrice"));
		String pdescribe = request.getParameter("pdescribe");
		Integer categoryid = Integer.parseInt(request.getParameter("categoryId"));
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String quality = request.getParameter("quality");
		
		Product product = new Product(pid, pname, price, purchasePrice, pdescribe, categoryid, brand, color, size, quality);
		
		ProductService productService = new ProductServiceImpl();
		productService.updateProduct(product);
		request.getRequestDispatcher("updateProductSuccess.jsp").forward(request, response);
	}
}
