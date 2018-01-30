package com.kjlink.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Product;
import com.kjlink.privilege.service.ProductService;
import com.kjlink.privilege.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");//数字
		String purchasePrice = request.getParameter("purchasePrice");//数字
		String pimage = request.getParameter("pimage");
		String pdescribe = request.getParameter("pdescribe");
		String categoryid = request.getParameter("categoryid");//数字
		String brand = request.getParameter("brand");
		String date = request.getParameter("shelftime");//日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date shelftime = null;
		try {
			shelftime = sdf.parse(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String quality = request.getParameter("quality");
		
		Product product=new Product(pname, Integer.parseInt(price), Integer.parseInt(purchasePrice), pimage, pdescribe, Integer.parseInt(categoryid), brand, shelftime, color, size, quality); 
		
		ProductService productService=new ProductServiceImpl();
		Integer i=productService.insertProduct(product);
		if(i==1) {
			
			request.getRequestDispatcher("/insertsuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/insertfailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
