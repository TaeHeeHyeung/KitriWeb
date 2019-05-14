<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="ko">

<head>
<title>headergood</title>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<%
	String root = request.getContextPath(); //server.xml의 context
%>
<!-- css files -->
<%--  <link href="<%=root%>/css/bootstrap.css" rel='stylesheet' type='text/css' />  --%>
<!-- bootstrap css -->
<%--  <link href="<%=root%>/css/style.css" rel='stylesheet' type='text/css' />  --%>
<!-- custom css -->
<%--  <link href="<%=root%>/css/font-awesome.min.css" rel="stylesheet">  --%>
<!-- fontawesome css -->

<!-- //css files -->
<link href="<%=root%>/css/css_slider.css" type="text/css" rel="stylesheet" media="all">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>


<!-- google fonts -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- //google fonts -->
</head>
<style type="text/css">
html {
	font-style: "Open Sans";
	font-size: "12px";
}

@media (min-width: 1200px).container {
    max-width: 1140px;
}
@media (min-width: 992px).container {
    max-width: 960px;
}
@media (min-width: 768px).container {
    max-width: 720px;
}
@media (min-width: 576px).container {
    max-width: 540px;
}
.container {
	width: 100%;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}
</style>

<body>

	<!-- example 1 - using absolute position for center -->
	<nav class="navbar navbar-expand-md bg-light navbar-light "> <!-- bg-light -->
		<div class="container">
			<a class="navbar-brand" href="<%=root%>/head_nav/?act=main"> 
			<img id="logo" src="<%=root%>/images/bus.png" width="50px" height="50px"> TayoTayo
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse" id="collapsingNavbar">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="<%=root%>/head_nav/?act=join">지역추천</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join">일정추천</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join" data-toggle="collapse">일정짜기</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join" data-toggle="collapse">지역추천</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join" data-target="#myModal" data-toggle="modal">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join" data-target="#myModal" data-toggle="modal">회원가입</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- //nav -->

	<!-- //header -->