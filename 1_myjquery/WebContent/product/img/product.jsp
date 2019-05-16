<%@page import="com.kitri.dto.ProductCategory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Product> list = (List<Product>) request.getAttribute("product_list");
%>

<script>
	$(function() {console.log("product.jsp: ready");
		var item = $("div[class='col-sm']");
		item.click(function() {
			console.log("product.jsp: click");
			$.ajax({
				method:"get",
				url: '/productinfo',
				data : {
					no : $(this).attr("id")
				},
				success : function(result) {

					$("div[id='product_detail']").html(result);
					console.log("product.jsp: success" + result);

				},
				error : function() {
					console.log("product.jsp: error");
				}
			});
			return false;
		});
	});
</script>


	<div class="row">
		<%
			for (int i = 0; i < list.size(); i++) {
				Product p = list.get(i);
				String no = p.getProd_no();
				String name = p.getProd_name();
				int price = p.getProd_price();
				String detail = p.getProd_detail();

				ProductCategory pc = p.getProductCategory();
				String cate = pc.getCate_name();
		%>
		<div class="col-sm" id="<%=no%>">
			<img src="/1_myjquery/product/img/<%=no%>.png"><br> 분류
			<%=cate%><br> 번호:
			<%=no%><br> 이름:
			<%=name%><br> 가격:
			<%=price%><br> 상세정보:
			<%=detail%><br>
		</div>
		<%
			} //end for
		%>
	</div>
	<div id="product_detail"></div>

