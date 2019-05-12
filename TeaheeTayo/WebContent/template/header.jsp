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
<title>TayoTayo</title>
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
<!-- <link href="/TaYo/css/bootstrap.css" rel='stylesheet' type='text/css' /> -->
<!-- bootstrap css -->
<!-- <link href="/TaYo/css/style.css" rel='stylesheet' type='text/css' /> -->
<!-- custom css -->
<!-- <link href="/TaYo/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- fontawesome css -->

<!-- //css files -->
<link href="/TaYo/css/css_slider.css" type="text/css" rel="stylesheet" media="all">

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


</style>
<body>
	<!-- header -->

	<!-- nav -->

<!-- expand-xx xx이하까지는 세로정렬 -->
	<nav class="navbar navbar-expand-md bg-light navbar-light">
		<div class="container">
			<!-- Brand -->

			<a class="navbar-brand " href="<%=root%>/head_nav/?act=main"> <img id="logo" src="/TaYo/images/bus.png" width="50px" height="50px">TayoTayo
			</a>
			<ul class="navbar-nav mr-auto ">
				<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=place">관광지/맛집 </a></li>
				<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=recomend">일정추천</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=plan">일정 짜기</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=root%>/head_nav/?act=join">함께 타요</a></li>
				<li class="nav-item "><a class="nav-link" href="">About</a></li>
			</ul>
			<ul class="navbar-nav ">
				<li class="nav-item"><a class="nav-link" href="">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="">회원가입</a></li>
			</ul>
		</div>
	</nav>



	<!-- //nav -->

	<!-- //header -->