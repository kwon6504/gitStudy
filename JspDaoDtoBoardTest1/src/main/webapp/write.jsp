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
		글제목:<input name="title"><br> 
		작성자:<input name="id"><br>
		<textarea name="text" rows="5" cols="50"></textarea>
		<br> <input type="submit" value="글쓰기">
	</form>
</body>
</html>