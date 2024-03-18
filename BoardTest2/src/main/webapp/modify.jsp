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
<title>Insert title here</title>
</head>
<body>
<%
String editNum = request.getParameter("num");
String title = null;
String id = null;
String content = null;
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
	Statement st = con.createStatement();
	String sql = "select*from cat_board where num"+editNum;
	System.out.println("==== 전송할 sql"+sql);
	ResultSet rs = st.executeQuery(sql);
	rs.next();
	title = rs.getString("title");
	content = rs.getString("content");
	id = rs.getString("id");
} catch(Exception e){
	e.printStackTrace();
}
%>
<form action="modifyproc.jsp" method="get">
글제목:<input name="title"><br>
작성자:<input name="id"><br>
글내용:<br>
<textarea name="content" rows="5" cols="50"></textarea>
<br><input type="submit" value="수정하기">
</form>
</body>
</html>