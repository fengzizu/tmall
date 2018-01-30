package com.kjlink.privilege.dao;

import java.sql.SQLException;
import java.util.List;

import com.kjlink.privilege.bean.User;

public interface UserDao {

	/**
	 * 用户登录验证
	 */
	public User selectUserPassword(String username,String password) throws SQLException;

	/**
	 * 用户查询
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectAllUser() throws SQLException; 
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteUserById(Integer id) throws SQLException;
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public User selectOneUserById(Integer id) throws SQLException;
	
 
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public void updateUser(User user) throws SQLException;

 
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException; 
	
 
}
