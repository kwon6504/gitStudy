<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- for문 -->
<c:forEach var="board" items="${list}">
    ${board.no}
    <a href="/board/read?no=${board.no}">${board.title}</a>
    ${board.id}
    <hr>
</c:forEach>
<a href="/board/write">글 작성</a>
</body>
</html>