package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl memberServiceImpl;

	public void init() throws ServletException {
		memberServiceImpl = MemberServiceImpl.GetInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		String path = "/index.jsp"; // 페이지 에러시 초기홈으로 돌리기

		// 회원가입
		if ("mvjoin".equals(act)) {
			MoveUrl.redirect(response, request, "/user/member/member.jsp");
		} else if ("mvlogin".equals(act)) {
			MoveUrl.redirect(response, request, "/user/login/login.jsp");
		} else if ("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = memberServiceImpl.idCheck(sid);
			// text/plan|xml|json
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);

		} else if ("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			String resultXML = MemberServiceImpl.GetInstance().zipSearch(doro);
//			SiteConstance.ENCODE xml은 무조껀 utf8이기 때문에 상수로 안해도된다.
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if ("register".equals(act)) {
			// 일반 자바가 처리할수없는 로직 => 두번째 컨트롤러가 처리
			path = MemberController.getMemberController().register(request, response);
			MoveUrl.forward(response, request, path);
		} else if ("login".equals(act)) {
			path = MemberController.getMemberController().login(request, response);
//			String id =request.getParameter("id");
//			String pass =request.getParameter("pass");
//			System.out.println("id"+ id +"pass"+pass);
			MoveUrl.forward(response, request, path);
		} else if ("logout".equals(act)) {
			path = MemberController.getMemberController().logout(request, response);
//			MoveUrl.forward(response, request, path); //이걸로해도됨
			MoveUrl.redirect(response, request, path); 
		} else if ("".equals(act)) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
