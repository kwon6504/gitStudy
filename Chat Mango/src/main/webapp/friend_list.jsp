<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.frinds_list.Dao"%>
<%@page import="com.peisia.frinds_list.Dto"%>
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
String no = "1";
/*String no = request.getParameter("no");*/
Dao dao=new Dao();

ArrayList<Dto> posts = dao.friendList(no); 

for(int i=0;i<posts.size();i=i+1){
Dto name = dao.name(posts.get(i).Frined_NAME);
%>

<hr>
<%=name.Frined_NAME %>#<%=name.Tag %>
<a href="friend_del.jsp?no=<%=posts.get(i).Frined_NAME%>">
	<input type="submit" value="삭제">
</a>
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