package com.kjlink.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Cart;
import com.kjlink.privilege.bean.CartItem;
import com.kjlink.privilege.bean.Product;
import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.ProductService;
import com.kjlink.privilege.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class Add2Cart
 */
public class Add2Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add2Cart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService ps = new ProductServiceImpl();
		String pid = request.getParameter("pid");

		Integer count = Integer.parseInt(request.getParameter("count"));
		Product product;
		try {
			product = ps.lookProductDetai(pid);

			CartItem cartItem = new CartItem(product, count);
			Cart cart = getCart(request);
			
			User user = (User) request.getSession().getAttribute("user");
			if(user != null) {

				cart.addCart(cartItem);
			}
			
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);

		}
		return cart;
	}
}
