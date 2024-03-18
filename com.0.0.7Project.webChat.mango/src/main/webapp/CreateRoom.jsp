<%@page import="com.MangoChat.RoomDB.R_Dao"%>
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
String roomName = request.getParameter("roomName");
String userMax = request.getParameter("userMax");
String myUserName = (String) session.getAttribute("userNo");
	R_Dao dao = new R_Dao();
	dao.create(myUserName,roomName,userMax);
	response.sendRedirect("/chat/index");
%>
</body>
</html>