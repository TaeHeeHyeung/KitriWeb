<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String name;
	int age;
	//init() Override 자동
	public void init() {
		name = "형태희";
		age = 27;
	}

%>
<%
	String color = age >= 18 ? "red" : "blue";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<%= name%>(<font color = "<%=color%>"><%= age%></font>)님 안녕하세요.
		<%out.print(name);%>(<%out.print(age);%>)님 안녕하세요.
	</div>
</body>
</htm
l>