<%@page import="com.lowlist.BoardDao.BoardListDao"%>
<%@page import="com.lowlist.Dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>

<%
Dto dto_write = new Dto(
		request.getParameter("title"),
		request.getParameter("id"),
		request.getParameter("content")
	);
	BoardListDao dao_write = new BoardListDao();
	dao_write.write(dto_write);
	response.sendRedirect("list.jsp");
%>


</body>
</html>