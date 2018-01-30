package com.kjlink.privilege.dao;

import java.sql.SQLException;
import java.util.List;

import com.kjlink.privilege.bean.Order;

public interface OrderDao {

	/**
	 * 提交到订单表
	 * @param order
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException;
	
	/**
	 * 提交到订单内容表，即中间表
	 * @param cartItem
	 * @throws SQLException
	 */
	public void insertOrderItem(int pid, String oid, int count, double subtotal) throws SQLException;

	/**
	 * 通过uid查询订单表
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public List<Order> selectOrder(int uid) throws SQLException;
}
