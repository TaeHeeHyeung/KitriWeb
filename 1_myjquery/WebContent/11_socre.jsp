
<%-- <%@page import="org.json.simple.JSONOBject"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%!int num;
	int score;%>
<%
	num++;
	score += Integer.parseInt(request.getParameter("star"));
%>
참여자 수:<%=num %><br>
총 점수 :<%=score%>



