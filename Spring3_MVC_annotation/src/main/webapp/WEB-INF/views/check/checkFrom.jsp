<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>입력 폼 입니다.</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h1>checkFrom.jsp</h1>
<form method="post" action="check.do">
	<input type="checkbox" name="hobby" value="1">운동
	<input type="checkbox" name="hobby" value="2">피아노
	<input type="checkbox" name="hobby" value="3">게임
	<input type="checkbox" name="hobby" value="4">수면
	<input type="submit" value="전송">
</form>

<script>
   $("form").submit(function() {
      if ($("input:checked").length < 1) {
         alert("취미를 한 개 이상 선택하세요");
         return false;
      }
   });
</script>
</body>
</html>