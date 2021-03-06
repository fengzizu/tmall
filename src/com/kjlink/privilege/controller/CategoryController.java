package com.kjlink.privilege.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjlink.privilege.service.CategoryService;
import com.kjlink.privilege.service.impl.CategoryServiceImpl;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private  CategoryService cs;

	// 请将所有关于商品类别的操作交给这个类底下所有相关的方法操作；

	@RequestMapping("/addCategory")
	public String addCatergory(String oneGrade, String twoGrade,Model model) {
		System.out.println("一级分类:"+oneGrade);
		System.out.println("二级分类:"+twoGrade);
		//接下来操作传入的数据 
		  
		   String[] twoArray = twoGrade.trim().split("-");
		   System.out.println("控制层的二级分类："+Arrays.toString(twoArray));
		  int c = cs.addCategory(oneGrade,twoArray);
		  
		  if(c==1) {
			  model.addAttribute("msg", 1);
			  
		  }else {
			  model.addAttribute("msg", 0);  
		  }
		return "addCategory";
	}

}
