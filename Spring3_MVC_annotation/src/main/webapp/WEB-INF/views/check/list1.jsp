<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>결과폼입니다.</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div>
	<h1>list1.jsp - 결과 화면입니다.</h1>
		<input type="checkbox" name="hobby" value="1" id="hobby1">운동
		<br>
		<input type="checkbox" name="hobby" value="2" id="hobby2">피아노
		<br>
		<input type="checkbox" name="hobby" value="3" id="hobby3">게임
		<br>
		<input type="checkbox" name="hobby" value="4" id="hobby4">수면
</div>
<script>
   <c:forEach var="h" items="${hobby}">
      $("input[value=${h}]").prop("checked",true)
   </c:forEach>
</script>


</body>
</html>