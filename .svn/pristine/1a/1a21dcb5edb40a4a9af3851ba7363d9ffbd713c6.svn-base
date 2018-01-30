package com.kjlink.privilege.service;

import java.util.List;

import com.kjlink.privilege.bean.User;

public interface UserService {
	 
	/**
	 * 用户登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserPassword(String username, String password);
	/**
	 * 查找用户
	 * @return
	 */
	public List<User> findAllUser();
	/**
	 * 删除用户
	 * @param id
	 */
	public void removeUserById(Integer id); 
	/**
	 * 根据用户id查找用户信息
	 * @param id
	 * @return
	 */
	public User findOneUserById(Integer id);
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	 
	public void updateUser(User user);
	
}
