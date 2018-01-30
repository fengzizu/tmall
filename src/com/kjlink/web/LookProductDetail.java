package com.kjlink.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjlink.privilege.bean.Product;
import com.kjlink.privilege.service.ProductService;
import com.kjlink.privilege.service.impl.ProductServiceImpl;

//这个是根据用户点击的商品查看具体的商品详情
public class LookProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookProductDetail() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService ps = new ProductServiceImpl();
		String pid = request.getParameter("pid");
		// System.out.println("lookProductDetail:"+pid);

		try {
			Product p = ps.lookProductDetai(pid);
			Integer productid = p.getPid();
			String pname = p.getPname();
			double price = p.getPrice();
			String[] color = p.getColor().split("-");
			String[] size = p.getSize().split("-");
			String[] quality = p.getQuality().split("-");
			String pdesc = p.getPdescribe();

			List<Object> list = new ArrayList<Object>();
			list.add(productid);
			list.add(pname);
			list.add(price);
			list.add(color);
			list.add(size);
			list.add(quality);
			list.add(pdesc);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/single.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
