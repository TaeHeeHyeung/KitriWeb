<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</div>
