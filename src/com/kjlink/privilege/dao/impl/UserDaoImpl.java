package com.kjlink.privilege.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.dao.UserDao;
import com.kjlink.privilege.util.DBContext;
import com.kjlink.privilege.util.DBUpdate;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void updateUser(User user) throws SQLException{
		Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE USER SET user_name= ? ,gander= ? ,birth_place= ? ,hobby= ? WHERE user_id= ?";
		
		ps = conn.prepareStatement(sql); 
		
		ps.setString(1,user.getUsername()); 
		ps.setString(2,user.getGander());
		ps.setString(3,user.getBirthPlace());
		//ps.setString(4,user.getInterest());
		ps.setInt(5, user.getId());
		
		ps.executeUpdate();
		
	}
	
	
	/**
	 * 查找用户
	 */
	public List<User> selectAllUser() throws SQLException {
		
		Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>(10);
		String sql = "SELECT user_id id,user_name username,gander,birth_place birthPlace,hobby FROM USER";
		ps = conn.prepareStatement(sql); 
		rs = ps.executeQuery();
		while (rs.next()) {
			//User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
			//userList.add(user);
		}
		/*释放连接*/
		DBContext.close(conn,null, null);
		return userList;
	}
	
	/**
	  * 查询单个用户
	  */
	public User selectOneUserById(Integer id) throws SQLException{
		
		Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "SELECT user_id id,user_name username,gander,birth_place birthPlace,hobby FROM USER WHERE user_id= ? ";
		ps = conn.prepareStatement(sql); 
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			 user = new User();
			 user.setId(rs.getInt("id"));
			 user.setUsername(rs.getString("username")); 
			 user.setGander(rs.getString("gander"));
			 user.setBirthPlace(rs.getString("birthPlace"));
			 //user.setHobby(rs.getString("hobby"));
			  
		}
		/*释放连接*/
		DBContext.close(conn,null, null);
		 
		return user;
	}
	
	/**
	 * 根据id删除用户
	 */
	public int deleteUserById(Integer id) throws SQLException{
		/*获取数据库连接对象*/
		Connection conn = DBContext.getConnection();
		String sql = "DELETE FROM USER WHERE user_id= ? ";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		int returnVal = ps.executeUpdate();
		/*释放资源*/
		DBContext.close(conn, null, ps);
		return returnVal;
		
	}

	/**
	 * 用户登录验证
	 */
	@Override
	public User selectUserPassword(String username, String password) throws SQLException {
		
		User user = null;
		String sql = "SELECT * FROM USER WHERE binary user_name = '"+ username +"' AND binary PASSWORD = '"+ password +"' ";
		
		ResultSet rs = DBUpdate.query(sql);
		
		//查到用户信息则实例化user
		while(rs.next()) {
			
			user = new User();
			
			//传递参数username和password
			user.setId(rs.getInt("user_id"));
			user.setUsername(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException {
		
		String sql = "INSERT INTO USER(user_name,password,gander,birth_place,hobby) VALUES(?,?,?,?,?);";
		
		String[] interest=user.getInterest();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<interest.length;i++) {
			if(i<interest.length-1) {
				
				sb.append(interest[i]+"-");
			}else {
				
				sb.append(interest[i]);
			}
		}
		String hobby=sb.toString();
		
		jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getGander(),user.getBirthPlace(),hobby);
		//System.out.println("插入成功！");
		/*Connection conn = DBContext.getConnection();
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getGander());
		ps.setString(4, user.getBirthPlace());
		ps.setString(5, user.getHobby());

		ps.executeUpdate();
		*/
	}
}