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

<form action="edit_proc.jsp">
<input type="hidden" name="no" value="<%=no%>"> 
<input name="title" value="<%=dto.title%>">
<input name="text" value="<%=dto.text%>">
<input type="submit" value="글수정">
</form>
<a href="list.jsp">목록으로</a>
</body>
</html>