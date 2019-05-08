<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.sql.*, java.net.URLEncoder"%>


<%
	request.setCharacterEncoding("utf-8");
	System.out.println("회원가입하러왔다.");
	//1.data get (이름, 아이디, 비번, 이메일1, 이메일2, 전번1, 전번2, 전번3, 우편번호, 주소, 상세주소)

	//2. Logic : 1의 data를 insert
	Connection con = null;
	PreparedStatement preStmt = null;
	int cnt = 0;

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	System.out.println("id:" + id + "pass" + pass);
	String emailId = request.getParameter("emailid");
	String emaildomain = request.getParameter("emaildomain");

	String zipcode = request.getParameter("zipcode");
	String address = request.getParameter("address");
	String address_detail = request.getParameter("address_detail");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");

	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		StringBuffer sql = new StringBuffer();
		sql.append("insert all \n ");
		//	sql.append("into member  \n ");
		sql.append("	into member (id, name,pass,emailid, emaildomain,joindate) \n ");
		sql.append("	values (?, ?, ?, ?, ? , sysdate ) \n");
		sql.append("	into member_detail (id, zipcode, address, address_detail, tel1,tel2,tel3) \n");
		sql.append("	values(?, ?, ?, ?, ? ,? ,?) \n");
		sql.append("select * from dual \n");

		preStmt = con.prepareStatement(sql.toString()); // 컴파일시 문법검사

		int idx = 0;
		preStmt.setString(++idx, id);
		preStmt.setString(++idx, name);
		preStmt.setString(++idx, pass);
		preStmt.setString(++idx, emailId);
		preStmt.setString(++idx, emaildomain);

		preStmt.setString(++idx, id);
		preStmt.setString(++idx, zipcode);
		preStmt.setString(++idx, address);
		preStmt.setString(++idx, address_detail);
		preStmt.setString(++idx, tel1);
		preStmt.setString(++idx, tel2);
		preStmt.setString(++idx, tel3);

		cnt = preStmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (preStmt != null)
				preStmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//3. ResponsePage		
	//	table의 개수에따라 2개 이상이 될 수도 있다.
	//	3-1. !0 : xxx님 회원가입을 환영합니다.
	//	3-2. 0 : 서버 문제로 회원가입이 실패하였습니다. 다음에 다시 시도하세요.
	//browser에서 실행됨
	response.setContentType("text/html; charset=utf-8");
	String root = request.getContextPath();
	
	if (cnt != 0) {
		response.sendRedirect(root + "/user/registerok.jsp?"+URLEncoder.encode(name,"UTF-8"));
	} else {
		response.sendRedirect(root + "/user/registerfail.jsp");
	}
%>
