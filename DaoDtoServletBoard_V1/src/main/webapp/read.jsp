<%@page import="com.lowlist.Dto.Dto"%>
<%@page import="com.lowlist.BoardDao.BoardListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>읽기화면</title>
</head>
<body>

<%
String no=request.getParameter("no");

	BoardListDao dao_read = new BoardListDao();
	Dto d_value = dao_read.read(no);
%>

<%=d_value.no%>
<%=d_value.id%>
<%=d_value.title%>
<hr>
<%=d_value.content%>

<a href = "del.jsp?no=<%=no%>">삭제</a>
<a href = "edit.jsp?no=<%=no%>">수정</a>
<a href = "list.jsp">돌아가기</a>

</body>
</html>