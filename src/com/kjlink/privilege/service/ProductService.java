package com.kjlink.privilege.service;

import java.sql.SQLException;
import java.util.List;

import com.kjlink.privilege.bean.Product;

public interface ProductService {
	
	/**
	 * 从数据库查询最新商品
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findNewProduct() ;
	
	/**
	 * 插入商品
	 * @param categoryid
	 * @return
	 */
	public Integer insertProduct(Product product);
	/**
	 * 删除商品
	 * @param id
	 */
	public void removeProductById(Integer pid);
	
	public List<Product> findProductByCategory(Integer categoryid);
	
	/**
	 * 后台管理商品信息
	 * 查询所有商品信息
	 * @return
	 */
	public List<Product> findProductsManage();
	
	public Product lookProductDetai(String pid) throws SQLException;
	
	public List<Product> oneProduct(int categoryId);

	public void updateProduct(Product p);  
	
}
