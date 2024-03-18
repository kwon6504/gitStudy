<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.domain.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${cp}/resources/common.css" >
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>									
</head>
<body>

<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
<c:forEach var="guest" items="${list}">
	<tr>
		<td>${guest.bno}</td>
		<td>
		<a href="${cp}/Guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>
</table>
<br>
    <c:if test="${pageing.hasPrev}">
        <a href="${cp}/Guest/getList?currentPage=${pageing.loadprevPage}&searchword=${pageing.searchword}">이전블럭가기</a>
    </c:if>
    
	<c:forEach var="pagenum" begin="${pageing.blockStartNo}" end="${pageing.blockEndNo}" step="1" varStatus="loop">
		<a href ="${cp}/Guest/getList?currentPage=${loop.index}&searchword=${pageing.searchword}">${loop.index}</a>
	</c:forEach>
	
	<c:if test="${pageing.hasNext}">
        <a href="${cp}/Guest/getList?currentPage=${pageing.loadnextPage}&searchword=${pageing.searchword}">다음블럭가기</a>
    </c:if>
<br>
	<form action="/spring/Guest/getList" method="get">
		<input type="text" name='searchword' >
		<input type="submit" value="검색">
	</form>
	<a href="${cp}/Guest/write">글쓰기</a>


	<%-- <a href="${cp}/Guest/pageing?bno=${pageing.bno}">1</a> --%>

	<%-- <input type="text" name='searchword' id="searchText">
	<input id="searchBtn" type="submit" value="검색" data-id="${cp}">
     --%>
<!-- <script>
	$(document).ready(function() {
		$("#searchBtn").on("click", function(){
			/* let address =$("#searchBtn").data.id;
			console.log(address); */
			let text = $("#searchText").val();
			/* let currentPage = $("#searchText").val(); */
			location.href = "../Guest/getList?searchword=" + text;
		});
	});
</script> -->
</body>
</html>
<%-- 
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.domain.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${cp}/resources/common.css" >
<title>Insert title here</title>
</head>
<body>

<!-- jstl 로 처리하면 더 짧게 가능 -->
<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
<!-- jstl 로 처리하면 더 짧게 가능 -->
<c:forEach var="guest" items="${list}">
	<tr>
		<td>${guest.bno}</td>
		<td>
		<a href="${cp}/Guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>
</table>
<c:forEach var="pageing" items="${list}">
	<a href ="${cp}/Guest/getList?nowpage=${pageing.nowpage}">${pageing.nowpage}</a>
</c:forEach>
<br>
<a href="${cp}/Guest/write">글쓰기</a>

</body>
</html> --%>
