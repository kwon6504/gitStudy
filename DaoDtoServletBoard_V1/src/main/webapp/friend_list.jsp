<%@page import="com.lowlist.BoardDao.Dao"%>
<%@page import="com.lowlist.Dto.Dto_friend"%>
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
<%

String no = (String)session.getAttribute("idNo");
System.out.println("받아온값"+no);
/*String no = request.getParameter("no");*/
Dao dao=new Dao();

ArrayList<Dto_friend> posts = dao.friend_list(no); 

for(int i=0;i<posts.size();i=i+1){
String name = dao.name(posts.get(i).Frined_NAME);
%>
<%=name %>
<%
}
%>
<hr>
<form action="friend_plus.jsp">
<input type="text" name = "userName" placeholder="닉네임"># 
<input type="text" name = "userTag" placeholder="테그">
<input type="submit" value="검색">
</form>
</body>
</html>