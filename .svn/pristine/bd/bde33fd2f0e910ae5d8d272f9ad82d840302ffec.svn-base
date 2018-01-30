package com.kjlink.privilege.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjlink.privilege.bean.Category;
import com.kjlink.privilege.dao.CategoryDao;
import com.kjlink.privilege.dao.impl.CategoryDaoImpl;
import com.kjlink.privilege.service.CategoryService;
import com.kjlink.privilege.util.DBContext;

@Service(value="cs")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier(value="cd")
   private  CategoryDao categoryDao;
	

	@Override
	public List<Category> showGuide() {

		try {
			return this.categoryDao.showGuide();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBContext.close(DBContext.getConnection(), null, null);
		}
		return null;
	}

	@Override
	@Transactional
	public int addCategory(String oneGrade, String[] array2) {
		System.out.println(oneGrade+"\t"+Arrays.toString(array2));
		
		int one = -1;
		int two = -1;

		try {
			one = categoryDao.addOneGrade(oneGrade);
			System.out.println("CategoryServiceImpl  第一个等级返回值："+one);
			if (one >= 0) {
				//测试事务的有效性设定的
				//int  xxx=10/0;
				two =categoryDao.addTwoGrade(one, array2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return two;
	}

}
