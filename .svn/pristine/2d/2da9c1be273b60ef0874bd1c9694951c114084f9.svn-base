package com.kjlink.privilege.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kjlink.privilege.bean.Cart;
import com.kjlink.privilege.bean.CartItem;
import com.kjlink.privilege.bean.Product;
import com.kjlink.privilege.bean.User;
import com.kjlink.privilege.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ProductService productService;
	
	//添加到购物车
	@RequestMapping("/addCart.action")
	public String addCart(@RequestParam(value = "pid") String pid, HttpServletRequest request) {
		Integer count = 1;
		Product product;
		try {
			product = productService.lookProductDetai(pid);
			CartItem cartItem = new CartItem(product, count);
			Cart cart = getCart(request);

			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				cart.addCart(cartItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "cart";
	}
	
	//清空购物车
	@RequestMapping("/clearCart.action")
	public String ClearCart(HttpServletRequest request) {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	
	//删除购物项
	@RequestMapping("/removeCart.action")
	public String RemoveCart(@RequestParam(value="pid") Integer pid,HttpServletRequest request) {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.removeCart(pid);
		return "cart";
	}
	
	//从session获得购物车
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		return cart;
	}

}
