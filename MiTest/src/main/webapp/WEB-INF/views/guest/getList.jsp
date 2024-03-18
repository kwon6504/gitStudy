<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${cp}/resources/common.css" >					
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<h1>방명록</h1>
<a href="${cp}/guest/write">새글쓰기!</a>
<hr>
<!-- jstl 로 처리하면 더 짧게 가능 -->

<c:forEach var="guest" items="${list}">
    ${guest.bno}
    <tr>
    <td>
    <a href="${cp}/guest/read?bno=${guest.bno}">${guest.btext}</a>
    </td>
    </tr>						
    <hr>
    <hr>
</c:forEach>
<fieldset>
	<legend>페이지 블럭</legend>
	${paging.getHtmlPageList()}
</fieldset>
<%-- <c:forEach var="guest" items="${list}"> --%>
<%--     <c:set var="bno" value="${guest.bno}" /> --%>
<%--     <c:set var="btext" value="${guest.btext}" /> --%>
<%--     ${bno} --%>
<%--     ${btext} --%>
<!--     <hr> -->
<%-- </c:forEach> --%>
<fieldset>
	<legend>검색</legend>
	<form action="${cp}/guest/search" method = "get">
	    <input type="hidden" name="currentPage" value="1">
		<input type="text" name="word">
		<input type="submit" value="검색">
	</form>
</fieldset>
</body>
</html>