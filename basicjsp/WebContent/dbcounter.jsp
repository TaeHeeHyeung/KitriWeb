<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.sql.*, javax.servlet.*, java.io.IOException"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!public class DBConnection {
		protected Connection con;
		protected Statement stmt;

		protected DBConnection() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

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
			return no;
		}

		public void updateNo() {
			try {
				String sql = "update counter set no = " + (no + 1);
				stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//end class

	DBNo dbNum;
	int cnt;
	int totallen;

	public void init() {
		dbNum = new DBNo();
	}%>

<body>
	<%
		dbNum.setConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		int no = dbNum.select();
		dbNum.updateNo();

		out.print("");
		out.print("<html>");
		out.print("<body>");

		out.print("당신은  ");
		// Integer.toString(cnt);
		String str = String.valueOf(no);

		// update delete 할 필요가 없기에 파일에 저장하는게 성능이 좋다.
		// 과제: DB 활용해보기 TAGLE : counter
		for (int z = 0; z < totallen - str.length(); z++) {
			out.print("<img src='/basicservlet/img/0.png' style='width:100px' > ");
		}
		for (int i = 0; i < str.length(); i++) {
			out.print("<img src='/basicservlet/img/" + str.charAt(i) + ".png' style='width:100px' > ");

			//			char ch = str.charAt(i);
			//			int num = (ch - 48);
			//			out.print("<img src='/basicservlet/img/" + num + ".png' style='width:100px' > ");
		}

		out.print("번째 방문자 입니다.");

		out.print("</body>");
		out.print("</html>");
	%>
</body>
</html>