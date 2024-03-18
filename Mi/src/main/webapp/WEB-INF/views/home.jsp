<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page session="false" %> --%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!-- el변수 cp에 경로저장 -->
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<a href="${cp}/test/getOnePlusTwo">1+2 결과 보러 가기</a>
	<%-- <a href="${cp}/guest/getList?currentPage=1">[방명록]</a> --%>
	<a href="${cp}/guest/getList?currentPage=1">[방명록]</a>
	<a href="${cp}/regmember/regForm">[회원가입]</a>
	<a href="${cp}/login/loginForm">[로그인]</a>
	<a href="${cp}/guest/testapi">[test api]</a>				


	<a href="${cp}/weather/apitest">[날씨api]</a>
	<a href="${cp}/travel/getList">[여행]</a>
	<a href="${cp}/fgo/list">[FGO]</a>
	<hr>
	세션확인 id : ${sessionScope.id}
	<hr>
	세션확인 id : ${id}
</body>
</html>
