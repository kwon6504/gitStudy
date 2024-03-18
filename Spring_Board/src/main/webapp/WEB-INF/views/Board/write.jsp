<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/board/write" method="post">
	    제목:<input type="text" name="title">
	    <br>
	    작성자:<input type="text" name="id">
	    <br>
		내용:<textarea rows="3" name="text"></textarea>
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>