<%@page import="com.peisia.domain.GuestVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

글번호:${read.bno}<br>
글내용:	
	<form action="/spring/Guest/modify" method="post">
		<c:set var="read" value="${read}"/>
		<input type="hidden" name='bno' value='${read.bno}' >
		<textarea name='btext'>${read.btext}
		</textarea>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>