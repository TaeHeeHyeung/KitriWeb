package com.kitri.basic;

import java.sql.*;

public class DBNo extends DBConnection {
	int no = 0;

	String url;
	String id;
	String pass;

	public int select() {
		try {
			String sql = "select no from counter";
			ResultSet resultSet = stmt.executeQuery(sql);
			resultSet.next();
			no = resultSet.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void updateNo() {
		try {
			String sql = "update counter set no = " + (no + 1);
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
