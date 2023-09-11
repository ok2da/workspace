<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>입력한 ID,비밀번호 출력</title>
<link href="resources/css/bootstrap.css" type="text/css" rel="stylesheet">
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" type="text/css"
   rel="stylesheet"> -->
<style>
	.container{width:30%}
	h3{text-align:center; color:gray; margin-top:10%}
</style>
</head>
<body>
<div class="container">
	<h3>list2.jsp 입니다.</h3>
		<table class="table">
		<tr>
			<th>ID</th><td>${bbsBean.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${bbsBean.pass}</td>
		</tr>
	</table>
</div>
</body>
</html>