package com.kjlink.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.UserService;
import com.kjlink.privilege.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SelectOneUserServlet
 */
public class SelectOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*获取客户端请求url中的参数id*/
		String userId = request.getParameter("id");
		/*创建service层对象，并调用下层方法*/
		UserService userService = new UserServiceImpl();
		User user=userService.findOneUserById(Integer.parseInt(userId));
		         
		request.setAttribute("user", user);
		request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
