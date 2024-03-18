<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<form action="ContorllerServlet" method="post">
	아이디:<input type="text" name="id">
	<br>
	pw:<input type="text" name="pw">
	<br>
	<input type="submit" name="sub" value="회원가입">
	</form>
	
</body>
</html>