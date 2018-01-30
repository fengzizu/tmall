package com.kjlink.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.UserService;
import com.kjlink.privilege.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("user") == null) {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			//获取username
	        User user = (User) request.getSession().getAttribute("user");
	        String username = user.getUsername();
			
			if(username.equals("admin")) {
				
				UserService userService = new UserServiceImpl();
				
				List<User> userList = userService.findAllUser();
				
				if(userList != null && userList.size() != 0) {
					
					request.setAttribute("userList", userList);
					request.getRequestDispatcher("/WEB-INF/jsp/select.jsp").forward(request, response);
				}
				
			}else {
				PrintWriter out = response.getWriter();
				
				out.flush();//清空缓存
				out.println("<script>");//输出script标签
				out.println("alert('This account is not administrators!');");//js语句：输出alert语句
				out.println("history.back();");//js语句：输出网页回退语句
				out.println("</script>");//输出script结尾标签
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
