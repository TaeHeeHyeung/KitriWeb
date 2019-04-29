package com.kitri.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {

	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection connection() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		return con;
	}

	private List<MemberDto> memberList(String name) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		con = connection();
		stmt = con.createStatement();
		String sql = "select no, name, id, joindate \n";
		sql += "from jdbctest \n";
		List<MemberDto> list = new ArrayList();
		if (name != null) {
			sql += "where name = '" + name + "'";
		}
		ResultSet rs = stmt.executeQuery(sql);
//		rest.first(); rest.next()가 최초로 호출될 때 first()가 호출되어있다.
		while (rs.next()) {
			MemberDto memberDto = new MemberDto();
			memberDto.setName(rs.getString("name"));
			memberDto.setJoindate(rs.getDate("joindate"));
			memberDto.setNo(rs.getInt("no"));
			list.add(memberDto);
		}

		// primaryKey인 데이터를 얻어온다면 while문을 쓸 필요가 없다.

		return list;
	}

	private List<MemberDto> memberList(int no) throws SQLException {
		String strNo = String.valueOf(no);
		Statement stmt = null;
		Connection con = null;
		con = connection();
		stmt = con.createStatement();
		String sql = "select no, name, id, joindate \n";
		sql += "from jdbctest \n";
		List<MemberDto> list = new ArrayList<MemberDto>();
		if (strNo != null) {
			sql += "where no = '" + strNo + "'";
		}
		ResultSet rs = stmt.executeQuery(sql);
//		rest.first(); rest.next()가 최초로 호출될 때 first()가 호출되어있다.
		rs.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setName(rs.getString("name"));
		memberDto.setJoindate(rs.getDate("joindate"));
		memberDto.setNo(rs.getInt("no"));
		list.add(memberDto);

		// primaryKey인 데이터를 얻어온다면 while문을 쓸 필요가 없다.

		return list;
	}

	private List<MemberDto> memberListDB(int no) throws SQLException {
		String strNo = String.valueOf(no);
		Statement stmt = null;
		Connection con = null;
		con = connection();
		stmt = con.createStatement();
		String sql = "select no, name, id, decode(joindate, to_char(sysdate))"
				+ "to_char(joindate,yy:mm:dd), to_char(sysdate,hh:mi:ss))";
		sql += "from jdbctest \n";
		List<MemberDto> list = new ArrayList<MemberDto>();
		if (strNo != null) {
			sql += "where no = '" + strNo + "'";
		}
		ResultSet rs = stmt.executeQuery(sql);
//		rest.first(); rest.next()가 최초로 호출될 때 first()가 호출되어있다.
		rs.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setName(rs.getString("name"));
		memberDto.setJoindate(rs.getDate("joindate"));
		memberDto.setNo(rs.getInt("no"));
		list.add(memberDto);

		// primaryKey인 데이터를 얻어온다면 while문을 쓸 필요가 없다.

		return list;
	}

	public static void main(String[] args) {
		SelectTest st = new SelectTest();

		try {
			List<MemberDto> list = st.memberList("형태희");

			int no = 92;
			System.out.println("회원 번호가" + no + "인 회원 검색!!!!");
			list = st.memberList(no);
			if (list == null) {
				System.out.println("회원 번호가" + no + "인 회원은 없습니다.");
			} else {
				for (MemberDto memdto : list) {
					System.out.println(memdto.toString());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
