<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul>
	<%
		String id = (String) session.getAttribute("loginInfo");
		if (id == null) {//로그인 안한 경우
	%>
	<!-- login.html -->
	<li><a href="user/login.html">로그인</a></li>
	<li><a href="user/singup.html">가입</a></li>

	<%
		} else { //로그인 한 경우
	%>
	<li><a href="user/login.html">로그인</a></li>
	<li><a href="user/singup.html">가입</a></li>
	<li><a href="logout">로그아웃</a></li>
	<%
		}
	%>
</ul>