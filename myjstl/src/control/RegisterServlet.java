package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

/**
 * Servlet implementation class MemberRegister
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		System.out.println("회원가입하러왔다.");
//		1.data get (이름, 아이디, 비번, 이메일1, 이메일2, 전번1, 전번2, 전번3, 우편번호, 주소, 상세주소)

//		2. Logic : 1의 data를 insert
		Connection con = null;
		PreparedStatement preStmt = null;
		int cnt = 0;

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

//		String emailId = request.getParameter("emailid");
//		String emaildomain = request.getParameter("emaildomain");
//
//		String zipcode = request.getParameter("zipcode");
//		String address = request.getParameter("address");
//		String address_detail = request.getParameter("address_detail");
//		String tel1 = request.getParameter("tel1");
//		String tel2 = request.getParameter("tel2");
//		String tel3 = request.getParameter("tel3");
//		System.out.println("name: " + name + "id: " + id + "pass: " + pass + "emailId: " + emailId);
//		System.out.println("emaildomain: " + emaildomain + "zipcode: " + zipcode + "address: " + address + "address_detail: " + address_detail);
		try {
			con =DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert \n ");
			sql.append("into customer (id, name,pass) \n ");
			sql.append("values (?, ?, ?) \n");
//			sql.append("insert all \n ");
//			sql.append("into member (id, name,pass,emailid, emaildomain, joindate) \n ");
//			sql.append("values (?, ?, ?, ?, ? , sysdate ) \n");
//			sql.append("into member_detail (id, zipcode, address, address_detail, tel1,tel2,tel3) \n");
//			sql.append("values(?,?,?,?,?,?,?)");
//			sql.append("select * from dual");
			preStmt = con.prepareStatement(sql.toString()); // 컴파일시 문법검사

			int idx = 0;
			preStmt.setString(++idx, id);
			preStmt.setString(++idx, name);
			preStmt.setString(++idx, pass);
			cnt = preStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, preStmt);
		}
//		3. ResponsePage		
//			table의 개수에따라 2개 이상이 될 수도 있다.
//			3-1. !0 : xxx님 회원가입을 환영합니다.
//			3-2. 0 : 서버 문제로 회원가입이 실패하였습니다. 다음에 다시 시도하세요.
// browser에서 실행됨
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (cnt != 0) {
			out.println(name + "님 회원가입을 환영합니다.");
			out.println("로그인후 모든 서비스를 이용할 수 있습니다.");
			out.println("<a href ='/myjquery/user/login.html'> 로그인창으로 </a>");
		} else {
			out.println("<font size='10' color ='red'>");
			out.println("서버에 문제가 있습니다 .");
			out.println("다시시도해주세요.");
			out.println("</font>");
		}
		out.println("</body>");
		out.println("</html>");
	}// doPost

}
