<%@page import="com.kitri.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>
<body>
	<%
		out.println("로그인실패!!!.");
		out.println("다시로그인해주세요.");
	%>
	<a href="<%=root%>/user?act=mvlogin">로그인</a>
	<%@ include file="/template/footer.jsp"%>