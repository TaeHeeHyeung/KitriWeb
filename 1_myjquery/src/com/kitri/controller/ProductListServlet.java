package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps;

	@Override
	public void init() throws ServletException {
		ps = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> productList = ps.findAll();
		request.setAttribute("product_list", productList);
		
		//webcontext바로 밑에서부터 / product
		String path = "/product/productlistresult.jsp";
		MoveUrl.forward(response, request, path);

	}

	
}
