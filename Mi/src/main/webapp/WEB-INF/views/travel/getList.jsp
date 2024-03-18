<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="../resources/common.css" >
</head>
<body>
	<c:forEach var="item" items="${list}">
${item.galTitle}<br>
<img class="picture" src="${item.galWebImageUrl}"><br>
${item.galPhotographyLocation}<br>
${item.galPhotographer}<br>
${item.galSearchKeyword}<br>
<hr>
	</c:forEach>
	
	<c:if test="${pageing.hasPrev}">
		<a href="${cp}/travel/getList?currentPage=${pageing.loadprevPage}">이전블럭가기</a>
	</c:if>
	
	<c:forEach begin="${pageing.blockStartNo}"
		end="${pageing.blockEndNo}" step="1" varStatus="loop">
		<a href="${cp}/travel/getList?currentPage=${loop.index}">${loop.index}</a>
	</c:forEach>

	<c:if test="${pageing.hasNext}">
		<a href="${cp}/travel/getList?currentPage=${pageing.loadnextPage}">다음블럭가기</a>
	</c:if>
</body>
</html>