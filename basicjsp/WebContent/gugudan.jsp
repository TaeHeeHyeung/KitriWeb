<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<h3>***구구단*** out.println</h3>
		<table class='table' style='border: 1px solid; width: 50%; margin: auto;'>
			<%
				for (int i = 1; i <= 9; i++) {
					out.println("<tr>");
					for (int j = 1; j <= 9; j++) {
						String color = "red";
						if (j % 2 == 0) {
							color = "blue";
						}
						out.println("<td style='border: 1px solid; height:30px;'>");
						out.println("	<span class=\"dan\" style='color: " + color + ";  text-align:center;'> " + i + "*"
								+ j + "= " + (i * j) + "</span>");
						out.println("</td>");
					}
					out.println("</tr>");
				}
			%>
		</table>

		<hr>

		<h3>***구구단***출력태그만</h3>
		<table class='table' style='border: 1px solid; width: 50%; margin: auto;'>
			<%
				for (int i = 1; i <= 9; i++) {
					out.println("<tr>");
					for (int j = 1; j <= 9; j++) {
						String color = "red";
						if (j % 2 == 0) {
							color = "blue";
						}
						out.println("<td style='border: 1px solid; height:30px;'>");
						out.println("	<span class=\"dan\" style='color: " + color + ";  text-align:center;'> " + i + "*"
								+ j + "= " + (i * j) + "</span>");
						out.println("</td>");
					}
					out.println("</tr>");
				}
			%>
		</table>
		<hr>

		<h3>***구구단***</h3>

		<table class='table' style='border: 1px solid; width: 50%; margin: auto;'>
			<%
				for (int i = 1; i <= 9; i++) {
			%><tr>
				<%
					for (int j = 1; j <= 9; j++) {
							String color = "red";
							if (j % 2 == 0) {
								color = "blue";
							}
				%>
				<td style='border: 1px solid; height: 30px;'>
				<span class='dan' style='color:<%=color%>; text-align:center;'>
				<%= i%>*<%= j%>= <%= (i * j)%></span>
				</td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
		<hr>
	</div>
</body>
</html>