<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글수정</title>
</head>
<body>
<%
String editNum = request.getParameter("num");
String title = null;
String content = null;
String id = null;
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
	Statement st = con.createStatement();
	String sql = "select*from cat_board where num="+editNum;
	System.out.println("==== 전송하려는 sql:" + sql);
	ResultSet rs = st.executeQuery(sql);
	rs.next();
	title = rs.getString("title");
	content = rs.getString("content");
	id = rs.getString("id");
} catch (Exception e) {
	e.printStackTrace();
}
%>

글번호:<br>
<%=editNum %><br>
<form action="modifyproc.jsp" method="get">
<input name="num" type="hidden" value=<%=editNum %>>
제목:<br>
<input name="title" value=<%=title %>><br>
내용:<br>
<textarea name="content" rows="5" cols="40"><%=content %></textarea><br>
작성자id:<br>
<input name="id" value="<%=id %>"><br>
<br>
<input type="submit" value="글수정하기">
</form>
</body>
</html>