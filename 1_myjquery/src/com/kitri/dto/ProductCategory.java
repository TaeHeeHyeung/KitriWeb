package com.kitri.dto;

public class ProductCategory {
	private String cate_no;
	private String cate_name;
//	private List<Product> list; 1대 다 관계를 고려하여 list
	public ProductCategory(String cate_no, String cate_name) {
		super();
		this.cate_no = cate_no;
		this.cate_name = cate_name;
	}
	public String getCate_no() {
		return cate_no;
	}
	public void setCate_no(String cate_no) {
		this.cate_no = cate_no;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	@Override
	public String toString() {
		return "ProductCategory [cate_no=" + cate_no + ", cate_name=" + cate_name + "]";
	}
	
}
