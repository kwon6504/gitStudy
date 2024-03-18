<%@page import="com.lowlist.Dto.Dto_friend"%>
<%@page import="com.lowlist.BoardDao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String searchName = request.getParameter("searchName");
String searchTag = request.getParameter("searchTag");
String No = (String)session.getAttribute("idNo");
Dao dao = new Dao();
// String MyUserNo = "1"; 이거 나중에 받아오는 값으로 수정해야됨
Dto_friend dto = new Dto_friend(
		request.getParameter("userNo")
		);
dao.friend_checkbox(searchName, searchTag, No);
%>
</body>
</html>