package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인하러왔다.");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인하러왔다.");

		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
//		1. 입력값 받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		System.out.println(id + " " + pass);
//		2. logic db에서 값 확인하기
		Connection con = null;
		PreparedStatement preStmt = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");

			String sql = "select name from member where id = ? and pass = ?";
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, id);
			preStmt.setString(2, pass);
			ResultSet rest = preStmt.executeQuery();
			String name = null;
			while (rest.next()) {
				name = rest.getString("name");
			}
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<body>");
			if (name != null) {
				out.println(name + "님 로그인을 환영합니다..");

			} else {
				out.println("로그인실패!!!.");
				out.println("다시로그인해주세요.");
			}
			out.println("</body>");
			out.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		3. 값 뿌리기
	}

}
