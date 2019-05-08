<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*, java.net.URLEncoder"%>

<%
	request.setCharacterEncoding("utf-8");
	//doGet(request, response);
	//1. 입력값 받기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	System.out.println(id + " " + pass);
	//2. logic db에서 값 확인하기
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
		String root = request.getContextPath();
		if (name != null) {
			response.sendRedirect(root + "/user/loginok.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
		} else {
			response.sendRedirect(root + "/user/loginfail.jsp");
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
%>
