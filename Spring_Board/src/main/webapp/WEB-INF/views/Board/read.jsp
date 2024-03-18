<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글 번호 : ${read.no}
<br>
글 제목 : ${read.title}
<hr>
작성자  : ${read.id}
<hr>
내용
<br>
${read.text}
<hr>
<a href="/board/modify?no=${read.no}">수정하기</a>
<a href="/board/del?no=${read.no}">삭제</a>
<br>
<a href="/board/getList">목록</a>
</body>
</html>