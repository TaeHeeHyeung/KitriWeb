package com.kitri.util;

import java.sql.*;

public class DBConnection {
	
	static {
		try {
			Class.forName(SiteConstants.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DBConnection() {}

	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(SiteConstants.DB_URL, SiteConstants.DB_USERNAME, SiteConstants.DB_PASSWORD);

	}
}
