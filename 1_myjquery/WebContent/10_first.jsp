<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- contentType="text/html; charset=UTF-8"  => response.setContentType("text/html; charset=UTF-8" )  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫번째 jsp 입니다.
	<%
	int i;//  멤버변수, 지역변수
	i = 99; //_jspService()내부에 작성될 구문
%>
	<%=i%>
	<%
		//expression: _jspService() 내부에 작성될 구문 
		//out.print() 자동호출됨.
	%>
	<%
		//declaration: _jspService 외부에 작성될 구문
	%>
	<%!int i;//클래스변수, 인스턴스 변수%>
	<%=i%>
	<%=this.i%>
	<hr>
	<h3>지시자</h3>
	<ul>
		<li>page directive: 속성-contentType, import, errorPage, isErrorPage, bruffer</li>
		<%
			Date dt = new Date();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		%>
		<%=sdf.format(dt)%>
		<li>include directive: 정적포함(.java 파일에 포함) , 속성-file</li>
		<li>taglib directive: 포함 , 속성-file</li>
	</ul>
	<hr>
	<h3>ACTION TAG</h3>
	<ul>
		<li>Standard Action Tag
			<ol>
<!-- 			여러뷰들을 합쳐서 표현해야될경우 사용 -->
				<li>jsp:include: 동적포함(실행 결과에 포함), 속성-page </li> 
				<li>jsp:forward</li>
				<li>jsp:param</li>
				<li>jsp:useBean</li>
				<li>jsp:setProperty</li>
				<li>jsp:getProperty</li>
			</ol>
		</li>
		<li>Custom Action Tag</li>
	</ul>
</body>
</html>