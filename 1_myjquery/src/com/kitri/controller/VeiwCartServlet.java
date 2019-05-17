package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dao.ProductDAO;
import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;
import com.kitri.service.ProductService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class VeiwCartServlet
 */
@WebServlet("/viewcart")
public class VeiwCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice;

	@Override
	public void init() throws ServletException {
		productservice = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Map<Product, Integer> c = (Map<Product, Integer>) session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<Product, Integer>();
		if (c != null) {
			Set<Product> keys = c.keySet();
			for (Product p : keys) {
				// 번호, 수량
				String no = p.getProd_no();
				try {
					int quantity = c.get(p);
					rc.put(p, quantity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("rcart", rc);
			String path = "/product/viewcartresult.jsp";
			MoveUrl.forward(response, request, path);
			System.out.println("viewcart c");
		}else {
			System.out.println("viewcart null");
		}
	}// end doGet
}
