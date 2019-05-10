<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp"%>

<%
	Cookie[] cookies = request.getCookies();
	String svid = "";
	String ckid = "";
	
	if (cookies != null) {
		for (Cookie c : cookies) {
			if ("kid_inf".equals(c.getName())) {
				svid = c.getValue();
				ckid = "checked";
				out.print(c.getValue());
				out.print(c.getName());
				out.print(ckid);			
				break;
			}
		}
	}
%>
<script type="text/javascript">
	function login() {
		var id = document.getElementById("id").value;
		var pass = document.getElementById("pass").value;
		if (id == "") {
			alert("아이디를 입력해주세요.");
		} else if (pass == "") {
			alert("비밀번호를 입력해주세요.");
		} else {
			document.getElementById("loginform").action ="<%=root%>/user";
			document.getElementById("loginform").submit();
		}
	}
	
	$(document).ready(function() {

	});
	function mvjoin(){
		document.location.href="<%=root%>/user?act=mvjoin";
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<h2>로그인</h2>
			<form id="loginform" method="post" action="">
				<input type="hidden" name="act" value="login">
				<div class="form-group" align="right">
					<label for="">아이디 저장<input type="checkbox" class="form-control" name="idsave" value="idsave" checked="<%=ckid%>"></label>
				</div>
				<div class="form-group" align="left">
					<label for="">아이디</label> <input type="text" class="form-control" id="id" name="id" placeholder="" value="<%=svid%>">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password" class="form-control" id="pass" name="pass" placeholder="">
				</div>
				<div class="form-group" align="center">
					<button type="button" class="btn btn-warning" id="loginBtn" onclick="javascript:login();">로그인</button>
					<button type="button" class="btn btn-primary" id="moveRegisterBtn" onclick="javascript:mvjoin();">회원가입</button>
				</div>
			</form>
		</div>
	</div>

	<%@include file="/template/footer.jsp"%>