<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호:${read.no}
	<form action="/board/modify" method="post">
		<input type="hidden" name='no' value='${read.no}'>
		작성자: <input name='id' value='${read.id}'>
		<br>
		글제목: <input name='title' value='${read.title}'>
		<br> 글내용:
		<textarea name='text'>${read.text}</textarea>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>