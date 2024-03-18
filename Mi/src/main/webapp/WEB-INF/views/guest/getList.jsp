<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/common.css" >
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
<!-- jstl 로 처리하면 더 짧게 가능 -->
<c:forEach var="guest" items="${list}">
	<tr>
		<td>${guest.bno}</td>
		<td><a href="${cp}/guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>
</table>
<hr>
	
	<c:if test="${pageing.hasPrev}">
		<a href="${cp}/guest/getList?currentPage=${pageing.loadprevPage}">이전블럭가기</a>
	</c:if>
	
	<c:forEach begin="${pageing.blockStartNo}"
		end="${pageing.blockEndNo}" step="1" varStatus="loop">
		<a href="${cp}/guest/getList?currentPage=${loop.index}">${loop.index}</a>
	</c:forEach>

	<c:if test="${pageing.hasNext}">
		<a href="${cp}/guest/getList?currentPage=${pageing.loadnextPage}">다음블럭가기</a>
	</c:if>

	<br>
<a href="/guest/write">새글 쓰기</a>


</body>
</html>