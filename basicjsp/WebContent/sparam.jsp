<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8"); //post일 경우 이것이 필요하다.
	//doGet(request, response);
	// 1. data get
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	int age = Integer.parseInt(request.getParameter("age"));
	// 2. logic
	String color = (age == 10) ? "pink" : "cyan";
%>
<body>
	<%
		// 3. reponse page
		// 10대 이하 id 빨강색 10대 이상 id 파랑색
		// name(id) 님 안녕하세요.
		//response.setContentType("text/html; charset = utf-8");
	%>
	<%=name%><span style='color: <%=color%>'> <%=id%>
	</span>님 안녕하세요

</body>
</html>