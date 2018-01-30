package com.kjlink.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Order;
import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.OrderService;
import com.kjlink.privilege.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class MyOrderServlet
 */
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 1. 从session获取uid
	 * 2. 传uid到service层并调用dao层方法
	 * 3. dao层通过uid查询订单表
	 * 4. 传值到jsp显示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderService orderService = new OrderServiceImpl();
		List<Order> orderList = new ArrayList<Order>();
	
		//获取user_id
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        
		orderList = orderService.selectOrder(uid);
		
		if(orderList != null) {
			
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("myorder.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
