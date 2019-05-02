package com.kitri.basic;

import java.sql.*;

public class DBConnection {
	protected Connection con;
	protected Statement stmt;

	protected DBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	https://docs.oracle.com/cd/E11882_01/appdev.112/e13995/oracle/jdbc/OracleDriver.html
//	url = jdbc:oracle:this:@192.168.14.52:1521:orcl
//	id ="kitri"
//	pass "kitri"
	public void setConnection(String url, String id, String pass) {
		try {
			con = DriverManager.getConnection(url, id, pass);
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
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

}
