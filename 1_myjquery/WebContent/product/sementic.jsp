<%@page contentType="text/html;charset=utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semantic.jsp</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<style>
header {
	background-image: url("images/logo.png");
	background-repeat: no-repeat;
	background-position: right;
	height: 100px;
}

nav>ul {
	list-style: none;
	padding: 0;
}

nav>ul>li {
	display: inline-block;
}

footer {
	position: fixed;
	bottom: 0px;
	width: 100%;
	background-color: lightgray;
}
</style>

<script>
	//dom 트리에서 nav> ul> li > a 객체들 찾기
	$(function() {
		var aArr = $("nav>ul>li>a");
		$(aArr).click(function() {
			console.log("called");
			var vurl = $(this).attr("href");
			if (vurl == 'logout') {
				$.ajax({
					url : vurl,
					method : "get",
					success : function(result) {
						location.href = "6_sementic.jsp"
					}

				});
			}else {
				$.ajax({
					url : vurl,
					method : 'get',
					success : function(result) {
						console.log(result);
						$("section").html(result);
					},error:function(){
						console.log("error");
					}
				});
			}

			return false;
		});
	});
</script>
</head>

<body>
	<header>
		<h3>My Web</h3>
	</header>
	<nav>
		메뉴
		<jsp:include page="/product/menu.jsp"/>
	</nav>
	<section>본문</section>
	<article></article>
	<footer>사업자 :현대자동차(주)|대표: 오문정 </footer>

</body>
</html>