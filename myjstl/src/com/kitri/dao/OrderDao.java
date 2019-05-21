package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class OrderDao {
	// OrderInfo has a Lines
	public void insert(OrderInfo info) throws AddException {
		Connection con = null;
		try {
			con = DBConnection.makeConnection();
			con.setAutoCommit(false);
			insertInfo(con, info);
			insertLine(con, info.getLines());
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new AddException("주문 추가 오류" + e.getMessage());
		} finally {
			DBClose.close(con);
		}
	}

	public void insertInfo(Connection con, OrderInfo info) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into order_info(order_no, order_id) " + "values(order_seq.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			// 주문자아이디
			pstmt.setString(1, info.getCustomer().getId());
			pstmt.executeQuery();
		} finally {
			DBClose.close(pstmt);
		}
	}

	public void insertLine(Connection con, List<OrderLine> lines) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "insert into order_line(order_no, order_prod_no, order_quantity) "
				+ "values(order_seq.currval,? ,?)";
		try {// 일괄처리
			pstmt = con.prepareStatement(sql);
			for (OrderLine line : lines) {
				pstmt.setString(1, line.getProduct().getProd_no());
				pstmt.setInt(2, line.getOrder_quantity());
				// pstmt.executeUpdate();
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} finally {
			DBClose.close(pstmt);
		}

	}

	public List<OrderInfo> selectById(String id) {

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.makeConnection();
			String sql = "select info.order_no, order_dt, \n"
					+ "prod_no, prod_name, prod_price, order_quantity \n"
					+ "	from order_info info Join order_line line \n"
					+ "	on info.order_no = line.order_no \n"
					+ "	join product p \n"
					+ " on p.prod_no = line.order_prod_no \n" 
					+ " where order_id = ? \n"
					+ "order by order_no desc, prod_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			List<OrderLine> lines = null;
			List<OrderInfo> list = new ArrayList<OrderInfo>();
			OrderInfo info = null;
			OrderLine line = null;
			int old_order_no = -1; // 이전주문번호

			while (rs.next()) {
				info = new OrderInfo();
				int order_no = rs.getInt("order_no");
				if (order_no != old_order_no) { // 주문번호가 다를 때
					info = new OrderInfo();
					list.add(info);
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					lines = new ArrayList<OrderLine>();
					info.setLines(lines);
					old_order_no = order_no;
				}

				line = new OrderLine();

				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				Product p = new Product();
				p.setProd_no(prod_no);
				p.setProd_name(prod_name);
				p.setProd_price(prod_price);
				// p채우기
				line.setProduct(p);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				lines.add(line);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
}
