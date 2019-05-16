<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	Product product = (Product) request.getAttribute("product");
%>
<div>
	<div class="row">
		<div class="col-sm-4">
			<img src="/1_myjquery/product/img/<%=product.getProd_no()%>.png"><br>
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
<div style="height:100px; width:100px;">
 <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Dropdown button
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Link 1</a>
      <a class="dropdown-item" href="#">Link 2</a>
      <a class="dropdown-item" href="#">Link 3</a>
    </div>
  </div>
</div>
