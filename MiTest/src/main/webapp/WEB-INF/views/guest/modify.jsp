<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!-- el변수 cp에 경로저장 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기 진짜오나??? 글번호:${read.bno}
	<br> 글내용:

	<form action="${cp}/guest/modify" method="post">
		<input type="hidden" name='bno' value='${read.bno}'>
		<textarea name='btext'>
			${read.btext}
		</textarea>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>