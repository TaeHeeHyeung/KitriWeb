<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page buffer="100kb"%>
<%@page errorPage="12_err.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int i = 1; i <= 10000; i++) {
	%>
	<%=i%>
	<%
		}
	%>

	<%
		//a.txt파일을 byte단위로 읽기위한 스트림객체생성
		FileInputStream fis = new FileInputStream("a.txt");
	%>
</body>
</html>