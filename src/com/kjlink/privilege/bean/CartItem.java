package com.kjlink.privilege.bean;

public class CartItem {
	
	private Product product;//商品（信息）
	private Integer count;//数量
	private double subtotal;//小计（商品价格*数量）
	
	public CartItem(Product product, Integer count) {
		
		this.product = product;
		this.count = count;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getPrice();
	}
//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}
	
}
