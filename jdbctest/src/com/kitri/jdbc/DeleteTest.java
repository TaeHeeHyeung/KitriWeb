package com.kitri.jdbc;

import java.sql.*;

//java2의 가입일을 현재 시간으로 수정.
public class DeleteTest {
	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection makeConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri",
				"kitri");
		return connection;
	}

	public static void main(String[] args) {
		DeleteTest ut = new DeleteTest();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ut.makeConnection();
			System.out.println("연결성공");
			stmt = con.createStatement();
			String sql = "delete jdbctest where no = 12";
			int cnt = stmt.executeUpdate(sql);
			if (cnt == 0) {
				System.out.println("delete 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// end main
}
