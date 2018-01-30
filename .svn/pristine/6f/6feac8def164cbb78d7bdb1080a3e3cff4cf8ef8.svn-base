package com.kjlink.privilege.service;

import java.util.List;

import com.kjlink.privilege.bean.Order;

public interface OrderService {

	/**
	 * 提交到订单表
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**
	 * 提交到订单内容表，即中间表
	 */
	public void addOrderItem(int pid, String oid, int count, double subtotal);
	
	/**
	 * 通过uid查询订单表
	 * @param uid
	 * @return
	 */
	public List<Order> selectOrder(int uid);
	
}
