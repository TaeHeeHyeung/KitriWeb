package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService ps = new ProductService();
		List<Product> productList = ps.findAll();
//		System.out.println(productList.get(0).toString());
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("product_list", productList);

		String path = "/product/productlistresult.jsp";

		MoveUrl.forward(response, request, path);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
