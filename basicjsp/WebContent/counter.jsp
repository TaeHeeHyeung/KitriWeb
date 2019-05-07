<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%!int totallen;
	int cnt;

	public void init() {
		totallen = 5;
		cnt = 0;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		cnt++;
		out.print("<html>");
		out.print("<body>");

		out.print("당신은  ");
		// Integer.toString(cnt);
		String str = String.valueOf(cnt);

		//update delete 할 필요가 없기에 파일에 저장하는게 성능이 좋다.
		//과제: DB 활용해보기 TAGLE : counter
		for (int z = 0; z < totallen - str.length(); z++) {
	%><img src='/basicservlet/img/0.png' style='width: 100px'>
	<%
		}
		for (int i = 0; i < str.length(); i++) {
	%><img src='/basicservlet/img/<%=str.charAt(i)%>.png' style='width: 100px'>
	<%
		}

		out.print("번째 방문자 입니다.");

		out.print("</body>");
		out.print("</html>");
	%>
</body>
</html>