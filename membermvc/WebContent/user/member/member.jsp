<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/template/header.jsp"%>

<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
	/* 	&('#registerBtn').onclick(function () {
	 alert("회원가입?");
	 }) */
});
	var idcount=1;
	function register() {
		/* var re = /^[a-zA-Z0-9]{4,12}$/ //아이디와 패스워드가 적합한지 검사할 정규식
		if (!check(re, document.getElementById("name"), "잘못된 형식으로 이름을 입력하였습니다.")) {
			return false;
		} */
		if (document.getElementById("name").value == "") {
			alert("이름 입력해라!!!!");
			return;
		} else if (idcount !=0) {
			alert("아이디 중복검사해주세요!!!!");
			return;
		} else if (document.getElementById("pass").value == "") {
			alert("비밀번호 입력해라!!!!");
			return;
		} else if (document.getElementById("pass").value != document
				.getElementById("passcheck").value) {
			alert("비밀번호가 다르다!!!!");
			return;
		} else {
			document.getElementById("memberform").action = "<%=root%>/user"
			document.getElementById("memberform").submit();
		}
	}
	function check(re, what, message) {
		if (re.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
		//return false;
	}


	//아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
	var idck = 0;
	$(function() {
		//idck 버튼을 클릭했을 때 
		$("#idck").click(function() {
			//userid 를 param.
			var userid = $("#userid").val();
			$.ajax({
				async : true,
				type : 'POST',
				data : userid,
				url : "idcheck.do",
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if (data.cnt > 0) {
						alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
						//아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
						$("#divInputId").addClass("has-error")
						$("#divInputId").removeClass("has-success")
						$("#userid").focus();

					} else {
						alert("사용가능한 아이디입니다.");
						//아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
						$("#divInputId").addClass("has-success")
						$("#divInputId").removeClass("has-error")
						$("#userpwd").focus();
						//아이디가 중복하지 않으면  idck = 1 
						idck = 1;

					}
				},
				error : function(error) {
					alert("error : " + error);
				}
			});
		});
	});
	var resultView;
	function idcheck(){
		resultView = document.getElementById("idresult");
		var searchId = document.getElementById("id").value;
		if(searchId.length <5 || searchId.length > 16){
			resultView.innerHTML= '<font color ="gray">아이디는 5자이상 16자 이하입니다.</font>';
		}else{
			var params ="act=idcheck&sid="+searchId;
			console.log(params);
			sendRequest("<%=root%>/user", params, idcheckResult, "GET");
			//http://localhost/membermvc/user?act=idcheck&sid=%E3%85%81%E3%84%B4%E3%85%87%E3%84%B9%E3%84%B9
/* 			resultView.innerHTML=''; */
		}
	}
	function idcheckResult(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status== 200){
				var result = httpRequest.responseXML;
				/* xml 안의 문자는 엘리먼트이다 */
				console.log(result);
				console.log(result.getElementsByTagName("cnt")[0].firstChild);
				idcount = parseInt(result.getElementsByTagName("cnt")[0].firstChild.data);

				if(idcount == 0){
					resultView.innerHTML= '<font color ="blue">사용 가능합니다.</font>';
				}else {
					resultView.innerHTML= '<font color ="red">사용 불가능합니다..</font>';
				}
			}else{
				//에러페이지
			}
		}else{
			//로딩중...
		}
	}
</script>
</head>
<body>


	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<h2>회원가입</h2>
			<form id="memberform" method="post" action="">
				<input type="hidden" name="act" value="register">
				<div class="form-group" align="left">
					<label for="name">이름</label> <input type="text" class="form-control" id="name" name="name" placeholder="이름입력">
				</div>
				<div class="form-group" align="left">
					<!-- <label for="">아이디</label> <input type="text" class="form-control" id="id" name="id" placeholder="4자이상 16자 이하"> -->
					<label for="">아이디</label><input type="text" class="form-control" id="id" name="id" onkeyup="javascript:idcheck();" placeholder="4자이상 16자 이하">
					<div id="idresult"></div>

				</div>


				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password" class="form-control" id="pass" name="pass" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호재입력</label> <input type="password" class="form-control" id="passcheck" name="passcheck" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="email">이메일</label><br>
					<div id="email" class="custom-control-inline">
						<input type="text" class="form-control" id="emailid" name="emailid" placeholder="" size="25"> @ <select class="form-control" id="emaildomain" name="emaildomain">
							<option value="naver.com">naver.com</option>
							<option value="google.com">google.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hanmail.net">hanmail.net</option>
						</select>
					</div>
				</div>
				<div class="form-group" align="left">
					<label for="tel">전화번호</label>
					<div id="tel" class="custom-control-inline">
						<select class="form-control" id="tel1" name="tel1">
							<option value="010">010</option>
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="041">041</option>
							<option value="051">051</option>
							<option value="061">061</option>
						</select> _ <input type="text" class="form-control" id="tel2" name="tel2" placeholder="1234"> _ <input type="text" class="form-control" id="tel3" name="tel3" placeholder="5678">
					</div>
				</div>
				<div class="form-group" align="left">
					<label for="">주소</label><br>
					<div id="addressdiv" class="custom-control-inline">
						<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" size="7" maxlength="5" readonly="readonly">
						<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
					</div>
					<input type="text" class="form-control" id="address" name="address" placeholder="" readonly="readonly"> <input type="text" class="form-control" id="address_detail" name="address_detail" placeholder="" readonly="readonly">
				</div>
				<div class="form-group" align="center">
					<button type="button" class="btn btn-primary" id="registerBtn" onclick="javascriopt:register();">회원가입</button>
					<button type="reset" class="btn btn-warning">초기화</button>
				</div>
			</form>
		</div>
	</div>

	<%@include file="/user/member/zipsearch.jsp"%>
	<%@include file="/template/footer.jsp"%>