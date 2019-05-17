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
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/productinfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps;

	@Override
	public void init() throws ServletException {
		ps = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");
		Product product = ps.findByNo(no);		

//		request.setCharacterEncoding("UTF-8");
		request.setAttribute("product", product);

		String path = "/product/productinforesult.jsp";

		MoveUrl.forward(response, request, path);
	}

}
