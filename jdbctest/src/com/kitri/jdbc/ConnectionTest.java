package com.kitri.jdbc;

import java.sql.*;

public class ConnectionTest {

	public ConnectionTest() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void dbCnnect() {
		try {
			// 프로토콜 : ip: port: 식별자
			// 오라클: ocin this
			//Network 에러 ip port 불일치
			//Listener refused 에러: TNS listnerer orcl 서비스 실행 필요
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB Connection Success!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.dbCnnect();
	}

}
