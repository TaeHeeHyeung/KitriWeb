package com.kitri.util;

import java.sql.*;

public class DBConnection {
	
//	A a = new A();
//	A a; 선언 시 static이 호출된다;
	static {
		try {
			Class.forName(SiteConstance.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DBConnection() {

	}

	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(SiteConstance.DB_URL, SiteConstance.DB_USERNAME, SiteConstance.DB_PASSWORD);

	}
}
