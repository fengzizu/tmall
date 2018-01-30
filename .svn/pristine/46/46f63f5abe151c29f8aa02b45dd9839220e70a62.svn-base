package com.kjlink.privilege.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kjlink.privilege.bean.Order;
import com.kjlink.privilege.dao.OrderDao;
import com.kjlink.privilege.dao.impl.OrderDaoImpl;
import com.kjlink.privilege.service.OrderService;
import com.kjlink.privilege.util.DBContext;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = new OrderDaoImpl();
	
	/**
	 * 提交到订单表
	 * @param order
	 */
	public void addOrder(Order order) {
		
		try {
			this.orderDao.insertOrder(order);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
	}
	
	/**
	 * 提交到订单内容表，即中间表
	 */
	public void addOrderItem(int pid, String oid, int count, double subtotal) {
		
		try {
			this.orderDao.insertOrderItem(pid, oid, count, subtotal);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
	}
	
	/**
	 * 通过uid查询订单表
	 * @param uid
	 * @return
	 */
	public List<Order> selectOrder(int uid){
		
		List<Order> orderList = new ArrayList<Order>();
		
		try {
			orderList = this.orderDao.selectOrder(uid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}
}
