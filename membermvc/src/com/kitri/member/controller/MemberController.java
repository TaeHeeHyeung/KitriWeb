package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.SiteConstance;

/**
 * Servlet implementation class MemberController
 */
//db관련작업
public class MemberController {
	private static MemberController memberController;

	private MemberController() {
	}

	static {
		memberController = new MemberController();
	}

	public static MemberController getMemberController() {
		return memberController;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));

		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));

		int cnt = MemberServiceImpl.GetInstance().registerMember(memberDetailDto);
		if (cnt != 0) {
			request.setAttribute("userInfo", memberDetailDto);
			path = "/user/member/registerok.jsp";
		} else {
			path = "/user/member/registerfail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp"; // 에러시 홈으로 이동
		// 1. 입력값 받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.GetInstance().loginMember(id, pass);
		if (memberDto != null) {
			String idsv = request.getParameter("idsave");
//			System.out.println(idsv);
			if ("idsave".equals(idsv)) {
				//////////// cookie////////////////
				Cookie cookie = new Cookie("kid_inf", id);
				cookie.setDomain("localhost");
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 356 * 50);
				response.addCookie(cookie);
			}else {
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie c : cookies) {
						if ("kid_inf".equals(c.getName())) {
							System.out.println("MemberController 세션제거");
							c.setDomain("localhost");
							c.setPath(request.getContextPath());
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
			}

			//////////// sesstion///////////////
//			System.out.println(memberDto);
			HttpSession session = request.getSession();
			path = "/user/login/loginok.jsp";
			session.setAttribute("userInfo", memberDto);
//			request.setAttribute("userInfo", memberDto);
			//////////// sesstion///////////////
		} else {
			path = "/user/login/loginfail.jsp";
		}

		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate();// 세션안의 정보를 모두 제거
		return "/user/login/login.jsp";
	}
}// end MemberController
