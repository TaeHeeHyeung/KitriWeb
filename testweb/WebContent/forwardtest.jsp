<%@page import="testweb.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!Product p = new Product("상품", 2500);%>
	<c:set var="p" value="${p}" scope="request"></c:set>
	<jsp:forward page="/callservlet"></jsp:forward>


</body>
</html>