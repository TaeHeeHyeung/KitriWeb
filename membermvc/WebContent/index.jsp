<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/template/header.jsp"%>
<body>
	<div align="center">
		<h3>jsp를 이용한 회원가입 &amp; 로그인</h3>
		<a href="<%=root%>/user/member/member.jsp?act=mvjoin">회원가입</a> 
		<a href="<%=root%>/user/login/login.jsp?act=mvlogin">로그인</a>
	</div>
<%@include file="/template/footer.jsp"%>