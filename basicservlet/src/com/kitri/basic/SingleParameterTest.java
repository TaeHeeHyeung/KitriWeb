package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/singleparam")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// 1. data get
		String name = request.getParameter("name");
		//html에서 euc-kr로 인코딩했을 경우 크롬에서는 자동으로 utf-8로 인식하기 때문에 글자가 깨져보인다. 
		//이를 해결하려면 받은 내용을 utf-8로 바이트 분해 후 다시 euc-kr로 스트링으로 변환해주면 된다.
//		byte b[] = name.getBytes("utf-8");
//		name = new String(b, "euc-kr");
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
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
		writer.print("	</body>");
		writer.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doPost는 소켓을 통해 넘어온다. (내부적으로 io를 통해서 들어온다.)
		//get 방식은 url을 통해 넘어오기 때문에 setCharacterEncoding으로 해결이 불가능하다.
		request.setCharacterEncoding("utf-8"); //이것이 필요하다.
//		doGet(request, response);
		// 1. data get
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
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
		writer.print("	</body>");
		writer.print("</html>");		
	}

}
