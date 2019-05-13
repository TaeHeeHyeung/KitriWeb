<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//server.xml의 context
	String root = request.getContextPath();
%>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Grand Tour Travel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="Grand Tour Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>

<!-- css files -->
<link href="/TaYo/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- bootstrap css -->
<link href="/TaYo/css/style.css" rel='stylesheet' type='text/css' />
<!-- custom css -->
<link href="/TaYo/css/font-awesome.min.css" rel="stylesheet">
<!-- fontawesome css -->
<!-- //css files -->

<link href="/TaYo/css/css_slider.css" type="text/css" rel="stylesheet" media="all">

<!-- google fonts -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- //google fonts -->

<!-- <script type="text/javascript">
function mvpage(){
	
}
</script> -->
</head>
<body>
	<!-- header -->
	<header>
		<div class="container">
			<!-- nav -->
			<nav class="py-md-4 py-3 d-lg-flex">
				<div id="logo">
					<h1 class="mt-md-0 mt-2">
						<a href="<%=root%>/head"><span><img src="/TaYo/images/bus.png"></span> TayoTayo </a>
					</h1>
				</div>
				<label for="drop" class="toggle"> <span class="fa fa-bars"></span>
				</label> <input type="checkbox" id="drop" />
				<ul class="menu ml-auto mt-1">
					<li class=""><a href="<%=root%>/head_nav/?act=place">관광지/맛집 추천</a></li>
					<li class=""><a href="<%=root%>/head_nav/?act=recomend">여행지 일정 추천</a></li>
					<li class=""><a href="<%=root%>/head_nav/?act=plan">일정 짜기</a></li>
					<li class=""><a href="<%=root%>/head_nav/?act=join">함께 타기</a></li>
					<li class=""><a href="">About 타요타요</a></li>

					<li class="booking"><a href="">Login</a></li>
					<li class="booking"><a href="">회원가입</a></li>
				</ul>
			</nav>
			<!-- //nav -->
			
		</div>
	</header>
	<!-- //header -->