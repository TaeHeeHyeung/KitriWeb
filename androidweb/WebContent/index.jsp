<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	String method = request.getMethod();
	String opt = request.getParameter("opt");
	if(opt ==null || opt.equals("")){
		opt="default";
	}
%>
<%-- {
	"method" : "<%=method%>",
	"status": 1,
	"msg": "안드로이드용 WEB Application 입니다!",
	"opt": "<%=opt%>"
} --%>
<% List<Product> list = new ArrayList<>();
	list.add(new Product("001","아메리카노",2500));
	list.add(new Product("002","아이스아메리카노",2500));
	list.add(new Product("003","라떼",3000));
	ObjectMapper mapper = new ObjectMapper();
// 	mapper.writeValue(out, list);
	String result= mapper.writeValueAsString(list);
%>
<%=result%>
<%--[
	{"prod_no":"001", "prod_name":"아메리카노", "prod_price":2500},
	{"prod_no":"002", "prod_name":"아이스아메리카노", "prod_price":2500},
	{"prod_no":"003", "prod_name":"라떼", "prod_price":3000}
]--%>
