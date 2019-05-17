package com.kitri.service;

import java.util.List;

import com.kitri.dao.ProductDAO;
import com.kitri.dto.Product;

//usecase별로 만들어진다(service) 주문별로 로그인별로 장바구니별로
public class ProductService {

	private ProductDAO dao;
	
	public ProductService() {
		dao = new ProductDAO();
	}
	public List<Product> findAll(){
		return dao.selectAll();
	}
	public Product findByNo(String no) {
		return dao.selectByNo(no);
	}

}
