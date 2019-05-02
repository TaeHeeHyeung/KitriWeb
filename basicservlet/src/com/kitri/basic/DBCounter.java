package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbcounter")
public class DBCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBNo dbNum;
	int cnt;
	int totallen;

	public DBCounter() {
		dbNum = new DBNo();
	}

	@Override
	public void init() {
		cnt = 0;
		totallen = 8;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dbNum.setConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		dbNum.select();
		dbNum.updateNo();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("");
		writer.print("<html>");
		writer.print("<body>");

		writer.print("당신은  ");
		// Integer.toString(cnt);
		String str = String.valueOf(cnt);

		// update delete 할 필요가 없기에 파일에 저장하는게 성능이 좋다.
		// 과제: DB 활용해보기 TAGLE : counter
		for (int z = 0; z < totallen - str.length(); z++) {
			writer.print("<img src='/basicservlet/img/0.png' style='width:100px' > ");
		}
		for (int i = 0; i < str.length(); i++) {
			writer.print("<img src='/basicservlet/img/" + str.charAt(i) + ".png' style='width:100px' > ");

//			char ch = str.charAt(i);
//			int num = (ch - 48);
//			writer.print("<img src='/basicservlet/img/" + num + ".png' style='width:100px' > ");
		}

		writer.print("번째 방문자 입니다.");

		writer.print("</body>");
		writer.print("</html>");

	}

}
