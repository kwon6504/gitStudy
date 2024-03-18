<%@page import="com.lowlist.BoardDao.BoardListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기</title>
</head>
<body>
	
	<%
		String no=request.getParameter("no");
				BoardListDao dao_del = new BoardListDao();
				dao_del.del(no);
				response.sendRedirect("list.jsp");
		%>
	
	
	
</body>
</html>