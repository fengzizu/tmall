package com.kjlink.privilege.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kjlink.privilege.bean.Order;
import com.kjlink.privilege.dao.OrderDao;
import com.kjlink.privilege.util.DBContext;
import com.kjlink.privilege.util.DBUpdate;

public class OrderDaoImpl implements OrderDao{

	/**
	 * 提交到订单表
	 * @param order
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException {
		
		String sql = "INSERT INTO `order` (oid, `time`, total, state, user_id, cname, address, phone) " + 
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

		Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, order.getOid());
		ps.setString(2, order.getTime());
		ps.setDouble(3, order.getTotal());
		ps.setInt(4, order.getState());
		ps.setInt(5, order.getUid());
		ps.setString(6, order.getCname());
		ps.setString(7, order.getAddress());
		ps.setString(8, order.getPhone());
		
		ps.executeUpdate();
	}
	
	/**
	 * 提交到订单内容表，即中间表
	 * @param cartItem
	 * @throws SQLException
	 */
	public void insertOrderItem(int pid, String oid, int count, double subtotal) throws SQLException{

		String sql = "INSERT INTO orderitem (pid, oid, COUNT, subtotal) VALUES ('"+ pid +"', '"+ oid +"', '"+ count +"', '"+ subtotal +"') ";
		
		Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		
		ps.executeUpdate();
	}
	
	/**
	 * 通过uid查询订单表
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public List<Order> selectOrder(int uid) throws SQLException{
		
		Order order = null;
		List<Order> orderList = new ArrayList<Order>();
		
		String sql = "SELECT * FROM `order` WHERE user_id = ? ";
		
		ResultSet rs = DBUpdate.query(sql, uid);
		
		while(rs.next()) {
			
			order = new Order();
			
			order.setOid(rs.getString("oid"));
			order.setTime(rs.getString("time"));
			order.setTotal(rs.getDouble("total"));
			order.setState(rs.getInt("state"));
			order.setUid(rs.getInt("user_id"));
			order.setCname(rs.getString("cname"));
			order.setAddress(rs.getString("address"));
			order.setPhone(rs.getString("phone"));
			
			orderList.add(order);
		}
		return orderList;
	}
}
