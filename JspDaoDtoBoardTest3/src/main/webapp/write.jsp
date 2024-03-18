<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="write_proc.jsp">
		<input name="title" placeholder="제목"><br> 
		<input name="id" placeholder="작성자id"><br>
		<textarea name="text" rows="5" cols="50" placeholder="글내용"></textarea><br> 
		<input type="submit" value="쓰기">
	</form>
</body>
</html>