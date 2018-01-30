package com.kjlink.privilege.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.dao.UserDao;
import com.kjlink.privilege.service.UserService;
import com.kjlink.privilege.util.DBContext;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao ;
	
	public void updateUser(User user) {
		try {
			this.userDao.updateUser(user);
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally {
 		//执行完释放数据库连接资源
 			DBContext.close(DBContext.getConnection(), null, null);
 		}
	}
	
	
	/**
	 * 删除用户
	 */
	public void removeUserById(Integer id) {
		try {
			this.userDao.deleteUserById(id);
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
	}
	/**
	 * 查找用户
	 */
	public List<User> findAllUser(){
		
		try {
			return this.userDao.selectAllUser();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找单独的用户
	 */
	public User findOneUserById(Integer id) {
		try {
			return this.userDao.selectOneUserById(id);
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
		return null;
	}
	
	/**
	 * 用户登录验证
	 */
	@Transactional
	public User findUserPassword(String username, String password) {
		
		User user = null;
		try {
			user = this.userDao.selectUserPassword(username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
		return user;
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		
		try {
			this.userDao.insertUser(user);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			//执行完释放数据库连接资源
			DBContext.close(DBContext.getConnection(), null, null);
		}
	}
	  
}
