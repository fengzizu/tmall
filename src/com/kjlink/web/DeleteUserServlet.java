package com.kjlink.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.service.UserService;
import com.kjlink.privilege.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		/*获取客户端请求url中的参数id*/
		String userId = request.getParameter("id");
		/*创建service层对象，并调用下层方法*/
		UserService userService = new UserServiceImpl();
		userService.removeUserById(Integer.parseInt(userId));
		
		/*请求转发 */
		//request.getRequestDispatcher("/SelectServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
