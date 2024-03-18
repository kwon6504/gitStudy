<%@page import="com.lowlist.Dto.Dto"%>
<%@page import="com.lowlist.BoardDao.BoardListDao"%>
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
String no = request.getParameter("no");

BoardListDao dao_edit = new BoardListDao();
Dto dto_edit = dao_edit.read(no);
%>

<form action="edit_proc.jsp">

		<input type="hidden" name="no" value="<%=no%>">
		<input name="title" value="<%=dto_edit.title%>">
		<input name="content" value="<%=dto_edit.content%>">
		<input type="submit" value="수정">

</form>

<a href="list.jsp">리스트로</a>

</body>
</html>