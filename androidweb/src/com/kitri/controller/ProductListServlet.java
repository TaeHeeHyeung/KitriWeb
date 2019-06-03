package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;
import com.kitri.service.ProductService;

/**
 * Servlet implementation class Productlist
 */
@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public ProductListServlet() {
		service = new ProductService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = service.findAll();
		
		ObjectMapper mapper= new ObjectMapper();
		
		String jsonList = mapper.writeValueAsString(list);

		request.setAttribute("json", jsonList);
		String path = "/productlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
