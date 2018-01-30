package com.kjlink.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Cart;
import com.kjlink.privilege.bean.CartItem;
import com.kjlink.privilege.bean.Order;
import com.kjlink.privilege.bean.OrderItem;
import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.OrderService;
import com.kjlink.privilege.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class SubmitOrderServlet
 */
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
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
		
		//订单oid
		String oid = request.getParameter("oid");
		
		//获取user_id
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        
        //获取系统当前时间作为订单时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());

		//总计total，订单状态state，收货人姓名cname，地址address，电话phone
        Double total = Double.parseDouble(request.getParameter("total"));
        Integer state = Integer.parseInt(request.getParameter("state"));
        String cname = request.getParameter("cname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        
        Order order = new Order(oid, time, total, state, uid, cname, address, phone);
        OrderService orderService = new OrderServiceImpl();

        //添加到订单表
        orderService.addOrder(order);
        
        //得到购物车
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        
        for (CartItem cartItem : cart.getCartItem()) {
			
			// 订单项的信息从购物项获得的
			OrderItem orderItem = new OrderItem();
			
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			//orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
        
        //遍历OrderItem集合取出pid，循环遍历插入订单内容表
        Set<OrderItem> orderList = order.getOrderItems();
        
        for(OrderItem orderItem : orderList) {
        
        	//遍历cartItem集合获取pid, oid, count, subtotal，循环遍历插入订单内容表
        	int pid = orderItem.getProduct().getPid();
        	int count = orderItem.getCount();
        	double subtotal = orderItem.getSubtotal();
        	
        	//添加到订单内容表
        	orderService.addOrderItem(pid, oid, count, subtotal);
        	//事务待定
        }
        
        //订单表插入完成后清空购物车，并提示订单提交成功
		cart.clearCart();
		
		request.getRequestDispatcher("submitordersuccess.jsp").forward(request, response);
	}
}