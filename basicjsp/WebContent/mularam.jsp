<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//		*-----------------------*
	//좋아하는 과일 선택하세요
	//체크 박스 =>사과 바나나 수박
	//
	//~~님 안녕하세요?
	//당신이 좋아하는 과일은 사과, 바나나입니다.
	//당신이 좋아하는 과일은 없습니다.
	// 1. data get
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	int age = Integer.parseInt(request.getParameter("age"));
	String[] fruits = request.getParameterValues("fruit");

	//fruit=바나나&fruit=딸기
	// 2. logic
	String color = (age == 10) ? "pink" : "cyan";
	// 3. reponse page
	// 10대 이하 id 빨강색 10대 이상 id 파랑색
	// name(id) 님 안녕하세요.
%>
<body>
	<%=name%><span style='color :  <%=color%> ;'><%=id%></span> 님 안녕하세요.
	<br>당신이 좋아하는 과일은
	<%
		if (fruits == null) {
			out.print("없습니다.");
		} else {

			for (int i = 0; i < fruits.length; i++) {
				out.print(fruits[i]);
				if (i != fruits.length - 1) {
					out.print(",");
				}
			}
			out.print("입니다.");
		}
	%>
</body>
</html>