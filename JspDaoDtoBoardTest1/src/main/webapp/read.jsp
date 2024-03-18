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

글no:<%=d.no %><br>
작성자:<%=d.id %><br>
글제목:<%=d.title %>
<hr>
글내용:<br>
<%=d.text %><hr>

<a href="del.jsp?no=<%=no %>">글삭제</a>
<a href="edit.jsp?no=<%=no %>">글수정</a>
<a href="list.jsp">뒤로가기</a>
</body>
</html>