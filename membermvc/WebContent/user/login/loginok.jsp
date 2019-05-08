<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>
<body>
	<%
		String name = request.getParameter("name");
		out.println(name + "님 로그인을 환영합니다..");
	%>
	로그인 후 모든 서비스를 이용할 수 있습니다.
	<a href=""></a>
<%@ include file="/template/footer.jsp"%>