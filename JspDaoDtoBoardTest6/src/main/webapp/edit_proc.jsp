<%@page import="com.peisia.jsp.Dao"%>
<%@page import="com.peisia.jsp.Dto"%>
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
	Dto dto = new Dto(
			request.getParameter("title"),
			request.getParameter("text")
			);
	Dao dao = new Dao();
	dao.edit(dto,request.getParameter("no"));
	response.sendRedirect("list.jsp");
%>
</body>
</html>