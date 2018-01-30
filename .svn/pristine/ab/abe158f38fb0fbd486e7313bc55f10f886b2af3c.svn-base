package com.kjlink.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.UserService;
import com.kjlink.privilege.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 

        UserService userService = new UserServiceImpl();
		PrintWriter out = response.getWriter();  
		User user = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user = userService.findUserPassword(username, password);
		
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
	            response.sendRedirect("index.jsp");  
	            return;
	            
			}else {
				 out.flush();//清空缓存
		         out.println("<script>");//输出script标签
		         out.println("alert('已有用户登录，如需登录请先退出当前用户！');");//js语句：输出alert语句
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
