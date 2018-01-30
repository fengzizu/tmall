package com.kjlink.privilege.dao;

import java.sql.SQLException;
import java.util.List;

import com.kjlink.privilege.bean.Product;

public interface ProductDao {
	
	/**
	 * 从数据库查询最新商品
	 */
	public List<Product> findNewProduct() throws SQLException;
	
	
	public List<Product> findProductByCategory(Integer categoryid) throws SQLException;
	
	
	public int deleteProductById(Integer pid) throws SQLException;
	
	/**
	 * 插入商品
	 */
	public Integer insertProduct(Product product) throws SQLException;
	
	/**
	 * 后台管理商品信息
	 * 查询所有商品信息
	 * @return
	 * @throws SQLException
	 */
	public List<Product> selectProductsManage() throws SQLException;

	public Product lookProductDetail(String pid) throws SQLException;

	public List<Product> showOneProduct(int categoryId) throws SQLException;
	
	/**
	 * UpdateProduct
	 * @param product
	 * @throws SQLException
	 */

	public Integer updateProdect(Product p) throws SQLException;
}
