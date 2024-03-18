<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
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
Dto d = dao.read(no);
%>

<%=d.no %>
<%=d.id %>
<%=d.title %>
<hr>
<%=d.text %>
<hr>
<a href="list.jsp">글목록</a>
<a href="edit.jsp?no=<%=no%>">글수정</a>
<a href="del.jsp?no=<%=no%>">글삭제</a>

</body>
</html>