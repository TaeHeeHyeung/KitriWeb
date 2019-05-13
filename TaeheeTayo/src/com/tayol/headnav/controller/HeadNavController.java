package com.tayol.headnav.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.MoveUrl;

@WebServlet("/head_nav")
public class HeadNavController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if ("place".equals(act)) { //관광지/맛집 추천
			MoveUrl.redirect(response, request,"/tayoplace/place.jsp");
		}else if ("recomend".equals(act)) { //여행지 일정 추천
			MoveUrl.redirect(response, request,"/tayorecomend/recomend.jsp");
		}
		else if ("plan".equals(act)) { //일정 짜기
			MoveUrl.redirect(response, request,"/tayoplan/plan.jsp");
		}
		else if ("join".equals(act)) { //함께 타기
			MoveUrl.redirect(response, request,"/tayojoin/join.jsp");
		}
		else if ("about".equals(act)) { //함께 타기
			MoveUrl.redirect(response, request,"/tayoabout/about.jsp");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
