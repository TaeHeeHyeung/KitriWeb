package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiParam
 */
@WebServlet("/multiparam")
public class MultiParamrTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		*-----------------------*
//		좋아하는 과일 선택하세요
//		체크 박스 =>사과 바나나 수박
//		
//		~~님 안녕하세요?
//		당신이 좋아하는 과일은 사과, 바나나입니다.
//		당신이 좋아하는 과일은 없습니다.
		// 1. data get
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] fruits = request.getParameterValues("fruit");

//		fruit=바나나&fruit=딸기
		// 2. logic
		String color = (age == 10) ? "pink" : "cyan";
		// 3. reponse page
		// 10대 이하 id 빨강색 10대 이상 id 파랑색
		// name(id) 님 안녕하세요.
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("	<body>");
		writer.print(name + "(<span style='color : " + color + " ;'>" + id + "</span>)님 안녕하세요.");
		writer.print("<br>당신이 좋아하는 과일은 ");
		if (fruits == null) {
			writer.print("없습니다.");
		} else {
			for (int i = 0; i < fruits.length; i++) {
				if (i != fruits.length - 1) {
					writer.print(fruits[i] + ", ");
				} else {
					writer.print(fruits[i]);
				}
			}
			writer.print("입니다");
		}
		writer.print("	</body>");
		writer.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //이것이 필요하다.
		doGet(request, response);
	}

}
