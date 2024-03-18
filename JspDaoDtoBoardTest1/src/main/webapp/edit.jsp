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
	Dto dto = dao.read(no);
	%>

	<form action="edit_proc.jsp">
		작성자:<input type="hidden" name="no" value="<%=no%>"><br>
		글제목: <input name="title" value="<%=dto.title%>"><br>
		글내용:<br>
		<textarea name="text" rows="5" cols="50"><%=dto.text%></textarea>
		<br> <input type="submit" value="글수정">
	</form>
	<a href = "list.jsp">뒤로가기</a>
</body>
</html>