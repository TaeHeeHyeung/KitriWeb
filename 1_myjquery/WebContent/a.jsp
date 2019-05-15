<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<%
	Thread.sleep(5 * 100);
%>
<%=name %>(<%=id %>)님 반갑습니다.