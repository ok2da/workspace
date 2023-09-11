<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입 정보</title>
<link href="resources/css/bootstrap.css" type="text/css" rel="stylesheet">
<style>
	.container{width:30%}
</style>
</head>
<body>
<div class="container">
		<table class="table">
		<tr>
			<th><h4>회원가입 정보</h4></th>
		</tr>
		<tr>
			<th>ID</th><td>${join.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${join.pass}</td>
		</tr>
		<tr>
			<th>주민번호</th><td>${join.jumin1} - ${join.jumin2}</td>
		</tr>
		<tr>
			<th>E-Mail</th><td>${join.email}@${join.domain}</td>
		</tr>
		<tr>
			<th>성별</th><td>${join.gender}</td>
		</tr>
		<tr>
			<th>취미</th><td>
			<c:forEach var="h" items="${join.hobby}">
				${h}
			</c:forEach></td>
		</tr>
		<tr>
			<th>우편번호</th><td>${join.post1}</td>
		</tr>
		<tr>
			<th>주소</th><td>${join.address}</td>
		</tr>
		<tr>
			<th>자기소개</th><td>${join.intro}</td>
		</tr>
	</table>
</div>
</body>
</html>