package com.kitri.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveUrl {

	public static void redirect(HttpServletResponse response, HttpServletRequest request, String path) {
		try {
			response.sendRedirect(request.getContextPath() + path);//request의 버퍼를 다 버리고 전송한다 대신 모든 경로를 이동가능
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void forward(HttpServletResponse response, HttpServletRequest request, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
