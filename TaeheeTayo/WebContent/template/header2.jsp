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
<title>TayoTayo2</title>
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
<!-- <link href="<%=root%>/css/bootstrap.css" rel='stylesheet' type='text/css' /> -->
<!-- bootstrap css -->
<!-- <link href="<%=root%>/css/style.css" rel='stylesheet' type='text/css' /> -->
<!-- custom css -->
<!-- <link href="<%=root%>/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- fontawesome css -->

<!-- //css files -->
<link href="<%=root%>/css/css_slider.css" type="text/css" rel="stylesheet" media="all">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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

.headnav #left {
	min-width: 7rem;
}

.headnav #right {
	min-width: 5rem;
}

@media ( max-width : 1200px) {
}
</style>
<body>
	<!-- header -->

	<!-- nav -->

	<!-- expand-xx xx이하까지는 세로정렬 -->


	<!-- toogle -->

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand -->

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=root%>/head_nav/?act=main"> <img id="logo" src="<%=root%>/images/bus.png" width="50px" height="50px">TayoTayo
				</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">지역추천</a></li>
					<li class="active"><a href="#">일정추천</a></li>
					<li class="active"><a href="#">일정짜기</a></li>
					<li class="active"><a href="#">지역추천</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join">함께 타요</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Login</a></li>
					<li><a href="#">회원가입</a></li>
					<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
				</ul>
			</div>
			<!-- myNavbar -->
		</div>
	</nav>


	<!-- //nav -->

	<!-- //header -->