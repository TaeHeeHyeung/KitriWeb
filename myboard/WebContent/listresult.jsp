<%@page import="java.util.List"%>
<%@page import="com.kitri.dto.RepBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

$(function() {
	var arr =$('body > section > div > table > tbody > tr >td >a');
	$(arr).click(function() {
		var href= $(this).attr("href");
		console.log(href);
		$.ajax({
			url: href,
			method :'get',
			success : function(result) {
				$("section").html(result.trim());
			}
		});
		return false;
	});
	
	var arr= $('body > section > div > div > a');
	$(arr).click(function() {
		var href= $(this).attr("href");
		console.log(href);
		$.ajax({
			url: href,
			method :'get',
			success : function(result) {
				$("section").html(result.trim());
			}
		});
		return false;
	});
});
</script>

<c:set var="bean" scope="application" value="${requestScope.pagebean}"></c:set>
<div style="display: inline-block;">
	<table>
		<tr>
			<th>글번호</th>
			<th>원글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>비밀번호</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="repBoard" items="${bean.list}" varStatus="status">
		
			<tr>
				<td>${repBoard.board_seq}</td>
				<td>${repBoard.parent_seq}</td>
				<td>${repBoard.board_subject}</td>
				<td><a href="/myboard/boarddetail?board_seq=${repBoard.board_seq}">${repBoard.board_contents}</a></td>
				<td>${repBoard.board_writer}</td>
				<td>${repBoard.board_date}</td>
				<td>${repBoard.board_password}</td>
				<td>${repBoard.board_viewcount}</td>
			</tr>
		
		</c:forEach>

	</table>
	<div> 현재페이지 : </div>
	<div class="mokcha" style="text-align: center">
<!-- 	기호는 유니코드로 변경하자  -->
		<c:if test="${(bean.startPage) != 1}">
			<a href="/myboard/boardlist?currentPage=${bean.startPage-1}"><button class="left">◀</button></a>
		</c:if>
		
		<c:forEach var="index" begin="${bean.startPage}" end="${bean.endPage}" step="1" >
			<a href="/myboard/boardlist?currentPage=${index}">${index}</a>
		</c:forEach>
		<c:if test="${(bean.endPage) !=bean.totalPage}">
			<a href="/myboard/boardlist?currentPage=${bean.endPage+1}"><button class="right">▶</button></a>
		</c:if>
		
	</div>
</div>


