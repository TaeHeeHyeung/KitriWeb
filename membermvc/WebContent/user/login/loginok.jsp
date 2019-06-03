<%@page import="com.kitri.member.model.MemberDto"%>
<%@page import="com.kitri.util.MoveUrl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp"%>
<script type="text/javascript">
function deleteMember(){
	//alert
	//confirm: return true false
	//property 
	if(confirm("정말로 탈퇴?")){
		document.location.href="<%=root%>/user?act=deletemember";
		}
	}
</script>
<%
	MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
	//		MemberDto memberDto = (MemberDto) request.getAttribute("userInfo");
	if (memberDto != null) {
		String name = memberDto.getName();
		String id = memberDto.getId();
%>
<%=name%> 님 로그인을 환영합니다..<%=id%>
<%
	}
%>
<br>
<a href="<%=root%>/user?act=logout"> 로그아웃</a>
<a href="<%=root%>/user?act=mvmodify"> 정보수정</a>
<a href="#" onclick="javascript: deleteMember();"> 회원탈퇴</a>
<%
	if ("111".equals(memberDto.getId())) {
%>
<a href="<%=root%>/admin?act=memberlist"> 관리자</a>
<%
	} else {
		MoveUrl.redirect(response, request, "/user?act=mvlogin");
	}
%>
</br>
로그인 후 모든 서비스를 이용할 수 있습니다.

<a href=""></a>
<%@ include file="/template/footer.jsp"%>