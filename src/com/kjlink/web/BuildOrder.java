package com.kjlink.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Cart;
import com.kjlink.privilege.bean.CartItem;
import com.kjlink.privilege.bean.Order;
import com.kjlink.privilege.bean.OrderItem;
import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.util.UUIDUtils;

/**
 * Servlet implementation class BuildOrder
 */
public class BuildOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Order order = new Order();
		
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		order.setOid(UUIDUtils.getId());
		//order.setTime(new Date());
		order.setTotal(cart.getTotal());
		order.setState(1);
		User user=(User)request.getSession().getAttribute("user");
		order.setUser(user);
		
		for (CartItem cartItem : cart.getCartItem()) {
			
			// 订单项的信息从购物项获得的
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
