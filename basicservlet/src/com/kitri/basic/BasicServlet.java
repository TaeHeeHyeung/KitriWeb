package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("/basic")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
	int age;

	@Override
	public void init() throws ServletException {
		name = "형태희";
		age = 25;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");

		String color = (age > 18) ? "blue" : "red";

		out.println("</font color='steelblue'>" + name + "<font color ='" + color + "'>" + age + "</font>님 안녕하세요.");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
