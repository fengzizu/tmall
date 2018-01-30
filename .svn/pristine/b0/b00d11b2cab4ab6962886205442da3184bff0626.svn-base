package com.kjlink.privilege.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kjlink.privilege.bean.Category;
import com.kjlink.privilege.dao.CategoryDao;
import com.kjlink.privilege.util.DBContext;
import com.kjlink.privilege.util.DBUpdate;
import com.mysql.jdbc.Statement;

@Repository(value = "cd")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addOneGrade(String oneGrade) throws SQLException {

		// 生成键的持有者
		KeyHolder keyHolder = new GeneratedKeyHolder();
		// 保存一级商品类别

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				/*
				 * PreparedStatement
				 * pst=conn.prepareStatement("insert into  category (categoryname) values(?)",
				 * new String[]{});
				 */
				PreparedStatement pst = conn.prepareStatement("insert into  category (categoryname) values(?)",
						Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, oneGrade);
				return pst;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();

		/*
		 * String sql = "insert into  category (categoryname) values(?)";
		 * PreparedStatement ps = con.prepareStatement(sql); ps.setString(1, oneGrade);
		 * ps.executeUpdate(); ResultSet rs = ps.getGeneratedKeys(); // key茶插入数据产生的主键
		 * int gkey = -1; if (rs.next()) { gkey = (int) rs.getLong(1);
		 * }
		 * return gkey;
		 */
	}

	@Override
	public int addTwoGrade(int key, String[] twoArray) throws SQLException {
/*
		Connection conn = DBContext.getConnection();
		int info = -1;

		for (String str : array2) {
			String sql = "insert into category(categoryname,parentid) values(?,?)";
			QueryRunner qr = new QueryRunner();
			Object[] param = { str, key };
			info = qr.update(conn, sql, param);

		}

		return info;*/
		//使用jdbctemplate插入数据
		int  status=0;
		for (String string : twoArray) {
			 status=jdbcTemplate.update("insert into category (categoryname ,parentid) values (?,?)",string,key);
		}
		
		
		return status;

	}

	@Override
	public List<Category> showGuide() throws SQLException {

		List<Category> guideList = new ArrayList<Category>(10);
		String sql = "SELECT categoryid,categoryname FROM category " + "WHERE parentid IS NULL ";
		ResultSet rs = DBUpdate.query(sql);

		while (rs.next()) {
			Category c = null;
			int i = rs.getInt(1);
			c = new Category(i, rs.getString(2));
			List<Category> categoryList = new ArrayList<Category>(10);

			String sql1 = "SELECT categoryid,categoryname FROM category WHERE parentid=?";
			ResultSet rs1 = DBUpdate.query(sql1, i);
			while (rs1.next()) {
				Category c1 = null;
				c1 = new Category(rs1.getInt(1), rs1.getString(2));
				categoryList.add(c1);
			}
			c.setChildrenCategoryList(categoryList);
			guideList.add(c);
		}
		DBContext.close(null, rs, null);
		return guideList;
	}

}
