package com.kitri.util;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {
	
//	A a = new A();
//	A a; 선언 시 static이 호출된다;
//	static {
//		try {
//			Class.forName(SiteConstance.DB_DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private DBConnection() {
//
//	}
//
//	public static Connection makeConnection() throws SQLException {
//		return DriverManager.getConnection(SiteConstance.DB_URL, SiteConstance.DB_USERNAME, SiteConstance.DB_PASSWORD);
//
//	}
	
	public static Connection makeConnection() throws SQLException {
		Context ictx;
		Context ctx;
		Connection conn;
		try {
			ictx= new InitialContext();
			ctx = (Context) ictx.lookup("java:comp/env");
			DataSource dataSource = (DataSource) ctx.lookup("jdbc/kitri");
			conn = dataSource.getConnection("kitri", "kitri");
			return conn;	
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		//dbcp database connection pooling
		return null;
	}
}
