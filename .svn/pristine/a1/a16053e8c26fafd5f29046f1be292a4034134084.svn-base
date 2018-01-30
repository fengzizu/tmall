package com.kjlink.privilege.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

/*	@RequestMapping("/delete.action")
	public void deleteUser(@RequestParam(value = "id") Integer id) {
		userService.removeUserById(id);
	}*/

	@RequestMapping("/register.action")
	public String insertUser(User user) {

		userService.addUser(user);
		return "registerSuccess";
	}
	
	/**
	 * 用户登录验证
	 */
	@RequestMapping("/login.action")
	public String showUserPassword(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
			
		User user = userService.findUserPassword(username, password);
		
		if(user == null) {
			
			 out.flush();//清空缓存
	         out.println("<script>");//输出script标签
	         out.println("alert('用户名或密码不匹配，请注意区分大小写');");//js语句：输出alert语句
	         out.println("history.back();");//js语句：输出网页回退语句
	         out.println("</script>");//输出script结尾标签
			
		}else {
			

			if(request.getSession().getAttribute("user") == null) {

				//登陆成功，把user存入session域对象中  
				request.getSession().setAttribute("user", user);
				
				//重定向到index.jsp  
	            //response.sendRedirect("index.jsp");
				return "index";
				
			}else {
				 out.flush();//清空缓存
		         out.println("<script>");//输出script标签
		         out.println("alert('已有用户登录，如需登录请先退出当前用户！');");//js语句：输出alert语句
		         out.println("history.back();");//js语句：输出网页回退语句
		         out.println("</script>");//输出script结尾标签
			}
		}
		
		return "";
	}
}
