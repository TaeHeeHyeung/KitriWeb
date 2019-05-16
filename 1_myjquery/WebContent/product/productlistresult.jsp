<%@page import="com.kitri.dto.ProductCategory"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<%
	List<Product> list = (List<Product>) request.getAttribute("product_list");
%>


<script>
	$(function() {
		console.log("product.jsp: ready");
		var item = $("div[class='col-sm']");
		item.click(function() {
			console.log("product.jsp: click");
			$.ajax({
				method:"get",
				url: 'productinfo',
				data : {
					no : $(this).attr("id")
				},
				success : function(result) {
					$("div[id='product_detail']").html(result);
					console.log("product.jsp: success");
				},
				error : function() {
					console.log("product.jsp: error");
				}
			});
			return false;
		});

	});
</script>
</head>
<body>
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
</body>
</html>
