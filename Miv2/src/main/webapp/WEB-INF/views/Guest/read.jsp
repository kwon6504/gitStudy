<%@page import="com.peisia.domain.GuestVO"%>
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

글 읽기
<hr>
글번호:${read.bno}
<hr>
글내용:${read.btext}

 	<form action="/spring/Guest/del" method="get">
    	<c:set var="bno" value="${read}"/>
		<input type="hidden" name='bno' value='${read.bno}'>
		<input type="submit" value="삭제">
	</form>
	<form action="/spring/Guest/modify" method="get">
    	<c:set var="bno" value="${read}"/>
		<input type="hidden" name='bno' value='${read.bno}'>
		<input type="submit" value="수정하러가기">
	</form>

</body>
</html>
