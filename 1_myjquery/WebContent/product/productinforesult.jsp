<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Product product = (Product) request.getAttribute("product");
	String no = product.getProd_no();
%>
<script>
$(function() {
	console.log("function");
	var $bt = $(".cart");
	console.log($bt.html());
	$bt.click(function() {
		console.log("ajaxcalled");
		
		$.ajax({
			url: 'addcart',
			method:"get",
			data :'no=<%=no%>&quantity=' + $("input[name=quantity]").val(),
				success : function(result) {
					$(".addcartresult").remove();
					//$("section").html(result.trim()); //section영역 안에 추가된다.
					$("section").append(result.trim()); //section영역 끝에 추가된다.
					console.log("success");
				},
				error : function() {
					console.log(".jsp: error");
				}
			});
			return false;
		});
	});
</script>

<!-- <form action="addcart" method="get"> -->
<input type="hidden" name="no" value="<%=no%>">

<div>
	<div class="row">
		<div class="col-sm-4">
			<img src="/1_myjquery/product/img/<%=no%>.png"><br>
		</div>
		<div class="col-sm-8 row-eq-height">
			<div>
				이름:
				<%=product.getProd_name()%></div>
			<div class="pt-3">
				상세설명:
				<%=product.getProd_detail()%></div>
			<div>
				상품번호:<%=product.getProd_no()%></div>
			<div>
				가격:
				<%=product.getProd_price()%></div>
			<div class="d-flex flex-wrap align-content-end">수량:</div>
		</div>
	</div>
</div>
<div style="height: 100px; width: 100px;">
	수량: <input type="number" min="1" max="99" value="1" name="quantity">
	<button class="cart">장바구니넣기</button>
</div>
<section></section>
<!-- </form> -->