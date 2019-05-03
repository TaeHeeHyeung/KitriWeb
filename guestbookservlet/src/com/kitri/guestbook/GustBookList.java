package com.kitri.guestbook;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gblist")
public class GustBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		1. 글 이름 얻기
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
//		2. 로직 : 
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
		PreparedStatement preStmt = null;
		Connection con = null;

		try {

			String sql = "select * from gustbooklist values()";
			preStmt = con.prepareStatement(sql);
//			preStmt.execute

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
