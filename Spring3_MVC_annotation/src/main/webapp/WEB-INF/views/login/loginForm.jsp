<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼 입니다.</title>
<link href="resources/css/form.css" type="text/css" rel ="stylesheet">
</head>
<body>
 <form name="myform" action="login_ok1.do" method="post">
	<h3>loginForm.jsp</h3>
	<b>아이디</b>
	<input type="text" name="id" placeholder="Enter id" required>
	
	<b>Password</b>
	<input type="password" name="pass" placeholder="Enter password" required>
	
	<div class="clearfix">
		<button type="submit" class="submitbtn">전송</button>
	</div>
</form>

</body>
</html>