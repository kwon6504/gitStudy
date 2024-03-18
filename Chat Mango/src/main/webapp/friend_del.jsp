<%@page import="com.peisia.frinds_list.Dao"%>
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
String no = request.getParameter("no");
Dao dao = new Dao();
dao.friendDel(세션넘버 ,no);
response.sendRedirect("friend_list.jsp");
%>
</body>
</html>