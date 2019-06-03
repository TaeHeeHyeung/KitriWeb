<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--JSTL: JspStandardTagLibrary -->
<!-- 기본 라이브러리가 아닌 외부라이브러리사용할경우 taglib 지시자 사용 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
	<%-- <c:set var="num" value="98"></c:set> --%>

	<!-- 받을 param이 없으면 빈문자열을 받게 된다. -->
	<c:set var="num" value="${param.num}"></c:set>
	요청전달 데이터 num = ${num}
	<br>
	<!-- num이 빈문자열일 경우 산술연산에 참여하게되면 자동으로 숫자0으로 변환된다. -->
	<!--  jstl에서는 반드시 el표기법을 사용한다.  -->
	<c:if test="${num%2==0}">
짝수입니다.<br>
	</c:if>

	<hr>
	<c:choose>
		<c:when test="${num%2==0}">짝수입니다</c:when>
		<c:otherwise>홀수입니다.</c:otherwise>
	</c:choose>

	<hr>

	<%-- <%for(int i=1; i<=10; i++){} %> --%>
	<c:forEach begin="1" end="10" step="1" var="i">
${i}
</c:forEach>
	<c:set var="total" value="0"></c:set>

	<hr>
	<!-- step default =1  -->
	<!-- 변수가 존재할경우에는 값을 유지한체 재사용한다. -->
	<c:set var="total" value="0" />
	<c:forEach begin="1" end="10" var="i">
		<c:set var="total" value="${total+i}" />
	</c:forEach>
	1~10합: ${total}
	<hr>
	<%
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		request.setAttribute("list", list);
	%>

	<%-- <%for(String e: (String)request.getAttribute("list") ){} %> --%>
	<c:forEach var="e" items="${requestScope.list }">
${e}<br>
	</c:forEach>

	<hr>
	<!-- varStatus는 반복에 대한 정보를 갖고있다. varStatus="가명"-->
	<c:forEach var="e" items="${requestScope.list }" varStatus="obj">
${obj.index} - ${e} : ${obj.count}회 반복<br>
	</c:forEach>

	<hr>

	<%
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		request.setAttribute("map", map);
	%>

	<c:forEach var="e1" items="${requestScope.map}"> 
		${e1.key} : ${e1.value}<br>
	</c:forEach>

</body>
</html>