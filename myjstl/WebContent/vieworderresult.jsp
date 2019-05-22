<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="vieworder">
	<table style="text-align: center;">
		<tr>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>주문상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>주문수량</th>
		</tr>
		<c:forEach var="info" items="${requestScope.orderlist }">
			<tr>
				<c:set var="lines" value="${info.lines}" />
				<c:set var="lineSize" value="${fn:length(lines)}" />
				<td rowspan="${lineSize}">${info.order_no }</td>
				<td rowspan="${lineSize}">${info.order_dt }</td>
				<c:forEach var="line" items="${lines }" varStatus="obj">
					<c:set var="p" value="${line.product}" />
					<c:if test="${obj.index>0}">
						<tr>
					</c:if>

					<td>${p.prod_no }</td>
					<td>${p.prod_name }</td>
					<td>${p.prod_price }</td>
					<td>${line.order_quantity }</td>
				</c:forEach>
			</tr>
		</c:forEach>

	</table>
</div>
<%-- <div class="vieworder">
	<table style="text-align: center;">
		<tr>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>주문상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>주문수량</th>
		</tr>
		
		<%
			int old_order_no =-1;
			List<OrderInfo> list = (List<OrderInfo>) request.getAttribute("orderlist");
			for (OrderInfo info : list) {
		%>
		<tr>
		<%
			int order_no = info.getOrder_no(); //주문번호
			Date order_dt = info.getOrder_dt();//주문일자
			
			if(order_no == old_order_no){
			%><td></td><td></td><%
			}else{
			%><td> <%=order_no%> </td> <td><%=order_dt%></td> <%
				old_order_no = order_no;
			}
		%>
		
		<%
				List<OrderLine> lines = info.getLines();
				for (OrderLine line : lines) {
					Product p = line.getProduct();
					String prod_no = p.getProd_no();
					String prod_name = p.getProd_name();
					int prod_price = p.getProd_price();
					int quantity = line.getOrder_quantity();
					
					%>
					<td><%=prod_no %></td><td><%=prod_name %></td><td><%=prod_price %></td><td><%=quantity %></td>
					<%
				} //end line
		%>

		<%
			} //end info
		%>
		</tr>
	</table>
</div> --%>
