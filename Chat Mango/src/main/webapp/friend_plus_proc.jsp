<%@page import="com.peisia.frinds_list.Dao"%>
<%@page import="com.peisia.frinds_list.Dto"%>
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
String MyUserNo = request.getParameter("No");
Dao dao = new Dao();
// String MyUserNo = "1"; 이거 나중에 받아오는 값으로 수정해야됨
Dto dto = new Dto(
		request.getParameter("userNo")
		);
dao.friendCheckBox(searchName, searchTag, MyUserNo);
%>
</body>
</html>