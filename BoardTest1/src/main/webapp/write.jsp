<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글쓰기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<div class="back">
		<form action="writeproc.jsp" method="get">
		글제목:<br>
		<input name="title"><br>
		글작성자id:<br>
		<input name="id"><br>
		글제목:<br>
		<textarea name="content" rows="5" cols="50"></textarea>
		<br>
		<input type="submit" value="글쓰기">
	</form>
</div>
</body>
</html>