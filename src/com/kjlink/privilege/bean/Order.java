package com.kjlink.privilege.bean;

import java.util.HashSet;
import java.util.Set;

public class Order {
	
	private String oid;
	private String time;
	private double total;
	private Integer state;
	private String cname;
	private String address;
	private String phone;
	private Integer uid;
	private User user;
	
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public Order(String oid, String time, double total, Integer state, Integer uid, String cname, String address, String phone) {
		super();
		this.oid = oid;
		this.time = time;
		this.total = total;
		this.state = state;
		this.cname = cname;
		this.address = address;
		this.phone = phone;
		this.uid = uid;
	}

	public Order() {
		
	}

	public String getOid() {
		return oid;
	}
	
	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
