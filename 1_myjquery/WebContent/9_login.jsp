<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp"%>
<script type="text/javascript">
	$(function() {
		var $loginform =$("#loginform");
		$loginform.submit(function() {
			$.ajax({
				url:'/1_myjquery/login',
				method:'post',
				data:$("form").serialize(),
				success: function(result){
					if(result.trim() =='1'){//성공
						location.href="/1_myjquery/6_sementic.html";
						alert("성공 "+result.trim());	
					}else{//실패
						alert("실패 "+result.trim());	
					}
					alert("창띄움");
				},
				error: function(jqXHR,textStatus,errorThrown) {
					alert("에러");
				}	
			});
			return false;
		});
	});
	//dom 트리에서 nav> ul> li > a 객체들 찾기
	 $(function() {
		var aArr =$("nav>ul>li>a");
		$(aArr).click(function(){
			var vurl = $(this).attr("href");
			 //{} 객체정의 
			$.ajax({
				url: vurl,
				method:'post',
				success:function(result){
					$("section").html(result);
				}
			});
			return false;
		});
		
	}); 
	

	
	
	<%-- function login() {
		var id = document.getElementById("id").value;
		var pass = document.getElementById("pass").value;
		if (id == "") {
			alert("아이디를 입력해주세요.");
		} else if (pass == "") {
			alert("비밀번호를 입력해주세요.");
		} else {
			document.getElementById("loginform").action ="<%=root%>/user/loginprocess.jsp";
			document.getElementById("loginform").submit();
		}
	} --%>

<%-- 	function mvjoin(){
		document.location.href="<%=root%>/user/member.jsp";
	} --%>
</script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<h2>로그인</h2>
			<form id="loginform" method="post" action="">
				<div class="form-group" align="left">
					<label for="">아이디</label> <input type="text" class="form-control" id="id" name="id" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password" class="form-control" id="pass" name="pass" placeholder="">
				</div>

			</form>
			<div class="form-group" align="center">
				<button class="btn btn-warning" id="loginBtn" form="loginform">로그인</button>
				<button class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
			</div>
		</div>
	</div>

	<%@include file="/template/footer.jsp"%>