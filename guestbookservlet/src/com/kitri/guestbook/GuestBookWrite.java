package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBookWrite
 */
@WebServlet("/gbwrite")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		PreparedStatement preStmt = null;
		Connection con = null;
		System.out.println("name" + name + " subject" + subject + "content" + content);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
//			con = DriverManager.getConnection(GuestBookConstants.URL, GuestBookConstants.ID, GuestBookConstants.PASS);
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			String sql = "insert into guestbook (seq,name,subject,content,logtime) values(sq_guestbook.nextval, ?,?,?,sysdate )";
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, name);
			preStmt.setString(2, subject);
			preStmt.setString(3, content);
			preStmt.executeUpdate();

			
			out.println("		<h2>글목록</h2>\n");
			out.println("		<table class='table table-borderless'>\n");
			out.println("			<tr>\n");
			out.println("				<td align='right'><button type='button' class='btn btn-link'>글쓰기</button></td>\n");
			out.println("			</tr>\n");
			out.println("\n");
			out.println("		</table>\n");
			out.println("		<table class='table table-active'>\n");
			out.println("			<tbody>\n");
			out.println("				<tr>\n");
			out.println("					<td>작성자 : 홍길동</td>\n");
			out.println("					<td style='text-align: right;'>작성일 : 2019.05.05</td>\n");
			out.println("				</tr>\n");
			out.println("				<tr>\n");
			out.println("					<td colspan='2'><strong>글번호. 제목</strong></td>\n");
			out.println("				</tr>\n");
			out.println("				<tr>\n");
			out.println("					<td colspan='2'>내용</td>\n");
			out.println("				</tr>\n");
			out.println("			</tbody>\n");
			out.println("		</table>\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preStmt != null) {
					preStmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

}
