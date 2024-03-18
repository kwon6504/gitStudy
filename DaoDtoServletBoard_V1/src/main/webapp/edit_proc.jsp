<%@page import="com.lowlist.BoardDao.BoardListDao"%>
<%@page import="com.lowlist.Dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

<%
Dto dto_edit_proc = new Dto(
	request.getParameter("title"),
	request.getParameter("content")
	);

	BoardListDao dao_edit_proc = new BoardListDao();
	dao_edit_proc.edit(dto_edit_proc,request.getParameter("no"));
	response.sendRedirect("list.jsp");
%>


</body>
</html>