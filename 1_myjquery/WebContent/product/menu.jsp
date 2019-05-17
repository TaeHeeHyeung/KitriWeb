<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul>
	<%
		String id = (String) session.getAttribute("loginInfo");
		String root =request.getContextPath();
		if (id == null) {//로그인 안한 경우
	%>
	<!-- login.html -->
	<li><a href="<%=root%>/user/login.html">로그인</a></li>
	<li><a href="<%=root%>/user/singup.html">가입</a></li>

	<%
		} else { //로그인 한 경우
	%>
	<!-- 	<li><a href="user/login.html">로그인</a></li> -->
	<!-- 	<li><a href="user/singup.html">가입</a></li> -->
	<li><a href="logout">로그아웃</a></li>

	<%
		}
	%>
	<li><a href="logout">상품목록JSON</a></li>
	<li><a href="logout">로그아웃</a></li>
	<li><a href="viewcart">장바구니보기</a></li>
</ul>