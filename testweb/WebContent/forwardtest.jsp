<%@page import="testweb.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





	<form method="post" action="callservlet">
		<input class ="season" type="hidden">
		<input class ="season" type="hidden">
	</form>
	<script>
		var data = {
			email : 'email',
			age : 'age'
		};
		var formData = new FormData(data);
		$('form > input').attr("data", "data");
		$('form > input').attr("value", formData);
		
		$('form').submit();
	</script>




</body>
</html>