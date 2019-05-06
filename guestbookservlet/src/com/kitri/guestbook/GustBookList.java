package com.kitri.guestbook;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

@WebServlet("/gblist")
public class GustBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		1. 글 이름 얻기
		request.setCharacterEncoding("utf-8");
//		2. 로직 : 
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
		PreparedStatement preStmt = null;
		Connection con = null;
		response.setContentType("text/html; charset=utf-8");
		try {
			con = DriverManager.getConnection(GuestBookConstants.URL, GuestBookConstants.ID, GuestBookConstants.PASS);
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");

			String sql = "select * from gustbooklist";
			preStmt = con.prepareStatement(sql);
			ResultSet rest = preStmt.executeQuery();
			while (rest.next()) {
				int sq = rest.getInt(1);
				String name = rest.getString(2);
				String subject = rest.getString(3);
				Clob content = rest.getClob(4);
				Date date = rest.getDate(5);
				PrintWriter out = response.getWriter();

				Reader br = content.getCharacterStream();
				char[] cbuf = new char[(int) content.length()];
				br.read(cbuf);
				
				out.print(sq);
				out.print(name);
				out.print(subject);
				out.print(String.valueOf(cbuf));
				System.out.println(sq + " " + name + " " + subject + " " + content + " " + date);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		<h2>글목록</h2>
//		<table class="table table-borderless">
//			<tr>
//				<td align="right"><button type="button" class="btn btn-link">글쓰기</button></td>
//			</tr>
//
//		</table>
//		<table class="table table-active">
//			<tbody>
//				<tr>
//					<td>작성자 : 홍길동</td>
//					<td style="text-align: right;">작성일 : 2019.05.05</td>
//				</tr>
//				<tr>
//					<td colspan="2"><strong>글번호. 제목</strong></td>
//				</tr>
//				<tr>
//					<td colspan="2">내용</td>
//				</tr>
//			</tbody>
//		</table>

	}
}
