<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.kitri.member.model.MemberDetailDto"%>

<%@ include file="/template/header.jsp"%>

<%
	MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("userInfo");

	String name = request.getParameter("name");
	//인코딩 깨지는 유형
	//1. 코드에 치는 한글
	//<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	//2. get => byte 처리 필요 
	//3. post => requst setencoding 지정
	//4. url 쿼리스트링 직접 타이핑
	//response.sendRedirect(root + "/user/registerok.jsp?"+name); => java API 사용 :URLEncoder.encode(String value,String enc );
%>

<%=name%>님 회원가입을 환영합니다.
<br>
로그인후 모든 서비스를 이용할 수 있습니다. 아이디 :<%=memberDetailDto.getId()%><br>
이름:
<%=memberDetailDto.getName()%><br>
전화번호 :
<%=memberDetailDto.getTel1()%>-<%=memberDetailDto.getTel2()%>-<%=memberDetailDto.getTel3()%><br>
<a href='<%=root%>/user/login/login.jsp'> 로그인창으로 </a>

<%@ include file="/template/footer.jsp"%>