package com.kitri.dao;

import java.sql.*;
import java.util.List;

import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class CustomerDao {
	private static CustomerDao customerDao;
	static {
		customerDao= new CustomerDao();
	}

	public static  CustomerDao getCustomerDao(){
		return customerDao;
	}
	public Customer selectById(String id) throws com.kitri.exception.NotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();

			String selectByIdSQL = "select * from customer where id=?";
			pstmt = conn.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer c = new Customer();
				c.setId(id);
				c.setPass(rs.getString("pass"));
				c.setName(rs.getString("name"));
				return c;
			} else {
				throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException(e.getMessage());
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
	}//selectById

	public List<Customer> selectByName(String name) {

		return null;
	}

	public List<Customer> selectAll(String name) {

		return null;
	}

	public void insert(Customer c) {

	}

}
