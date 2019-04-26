package com.kitri.jdbc;

import java.sql.*;

public class InsertTest {

	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection makeConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("Connection Success");
		return connection;
	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		Connection conn = null;
		Statement stmt = null;
		String name = "형태희";
		String id = "hth0893";

		try {
			conn = it.makeConnection();
			String sql = "";

			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval,'" + name + "','" + id + "',sysdate)";
			// 세미콜론이 있으면 안된다.
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			if (cnt == 0) {
				System.out.println("insert 실패");
			} else {
				System.out.println("insert :" + cnt + "개 입력 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// end main

}
