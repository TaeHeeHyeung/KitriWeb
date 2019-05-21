<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
  <style type="text/css">
  	ul.menu>li>a{
  		padding-left: 10px;
  		padding-right: 10px;
  	}
  </style>
  <ul class= "menu">
<%String id =(String)session.getAttribute("loginInfo");
  if(id == null){ //로그인 안한 경우
%>
    <li><a href="user/login.html">로그인</a></li>
    <li><a href="user/signup.html">가입</a></li>  
<%}else{ //로그인한 경우 %>
    <li><a href="logout">로그아웃</a></li>
<%} %>
    <li><a href="productlist">상품목록</a></li>
    <li><a href="productlistjson">상품목록JSON</a></li>
    <li><a href="viewcart">장바구니보기</a></li>
    <%
    if(id != null){ //로그인 한 경우
    %>
    <li><a href="vieworder">주문내역보기</a></li>
    <%
    }
    %>
  </ul>