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
String readNum = request.getParameter("num");
String delNum = null;
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select*from cat_board where num="+readNum);
    rs.next();
    String num = rs.getString("num");
    String title = rs.getString("title");
    String content = rs.getString("content");
    String id = rs.getString("id");
    delNum = rs.getString("delNum");
%>
글제목: <%=title %><br>
작성자: <%=id %><br>
글내용: <br><%=content %><br>
<%
} catch (Exception e){
	e.printStackTrace();
}
%>
<hr>
<%if(delNum.equals("1")) { %>
<a href="backupproc.jsp">글복구하기</a>
<%} else { %>
<a href="modify.jsp">글수정하기</a>
<a href="delproc.jsp">글사제하기</a>
<%} %>
<a href="list.jsp">글목록보기</a>
</body>
</html>