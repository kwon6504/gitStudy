<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호 | 제목 | 작성자
<hr>
<%
Dao dao = new Dao();
ArrayList<Dto> posts=dao.list();

for(int i=0; i<posts.size();i++){
%>
<%=posts.get(i).no %>
<a href="read.jsp?no=<%=posts.get(i).no %>"><%=posts.get(i).title %></a>
<%=posts.get(i).text %>
<hr>
<%
} 
%>

<a href="write.jsp">글쓰기</a>
</body>
</html>