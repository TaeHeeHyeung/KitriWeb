package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class ProductDAO {
//	public static void main(String[] args) {
//		ProductDAO dao = new ProductDAO();
//		
//		List<Product> list =dao.selectAll();
//		for(Product p: list) {
//			p.toString();
//		}
//	}
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2)DB연결
			con = DBConnection.makeConnection();
			// 3)SQL송신
			String selectAllSQL =
					"select cate_no, cate_name,\n" + 
					"	prod_no, prod_name, prod_price, prod_detail\n" + 
					"   from product join product_category on cate_no= prod_cate"; 
					
		
			pstmt = con.prepareStatement(selectAllSQL);
			// 4)결과수신
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				String prod_detail = rs.getString("prod_detail");

				String cate_no = rs.getString("cate_no");
				String cate_name = rs.getString("cate_name");

				ProductCategory pc = new ProductCategory(cate_no, cate_name);
				Product p = new Product(prod_no, prod_name, prod_price, prod_detail, pc);
				list.add(p);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5)연결닫기
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}

	public Product selectByNo(String no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1)JDBC드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2)DB연결
			con = DBConnection.makeConnection();
			// 3)SQL송신
			String selectAllSQL ="select pc.cate_no, pc.cate_name,\n" + 
					"	p.prod_no, p.prod_name, p.prod_price, p.prod_detail, p.prod_cate\n" + 
					" from product p join product_category pc\n" + 
					" on p.prod_cate = pc.cate_no\n" + 
					" where prod_no=?";
					
			
			pstmt = con.prepareStatement(selectAllSQL);
			pstmt.setInt(1, Integer.parseInt(no));
			// 4)결과수신
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				String prod_detail = rs.getString("prod_detail");

				String cate_no = rs.getString("cate_no");
				String cate_name = rs.getString("cate_name");

				ProductCategory pc = new ProductCategory(cate_no, cate_name);
				return new Product(prod_no, prod_name, prod_price, prod_detail, pc);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5)연결닫기
			DBClose.close(con, pstmt, rs);
		}
		return null;
	}
}
