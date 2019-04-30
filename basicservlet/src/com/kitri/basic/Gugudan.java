package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Gugudan() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();

		writer.println("<table class='table' style='border: 1px solid;width:50%; margin:auto;'>");
		for (int i = 1; i <= 9; i++) {
			writer.println("<tr sytle=''>");
			for (int j = 1; j <= 9; j++) {
				String color = "red";
				if (j % 2 == 0) {
					color = "blue";
				}
				writer.println("<td style='border: 1px solid; height:100px;'>");
				writer.println("	<span class=\"dan\" style='color: " + color + ";  text-align:center;'> "
						+ i + " *" + j + "  = " + (i * j) + "</span>");
				writer.println("</td>");
			}
			writer.println("</tr>");
		}
		writer.println("</table>");

	}

}
