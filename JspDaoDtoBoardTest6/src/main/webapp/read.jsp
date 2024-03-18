<%@page import="com.peisia.jsp.Dto"%>
<%@page import="com.peisia.jsp.Dao"%>
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
Dto dto = dao.read(no);
%>

글번호: <%=dto.no %><br>
작성자: <%=dto.id %><br>
글제목: <%=dto.title %>
<hr>
<%=dto.text %>
<hr>
<div style="display: inline-block;">
  <form action="del.jsp" method="get">
    <input type="hidden" name="no" value="<%= no %>">
    <input type="submit" value="글삭제">
  </form>
</div>

<div style="display: inline-block;">
  <form action="edit.jsp" method="get">
    <input type="hidden" name="no" value="<%= no %>">
    <input type="submit" value="글수정">
  </form>
</div>

<div style="display: inline-block;">
  <form action="list.jsp" method="get">
    <input type="submit" value="글목록">
  </form>
</div>
</body>
</html>