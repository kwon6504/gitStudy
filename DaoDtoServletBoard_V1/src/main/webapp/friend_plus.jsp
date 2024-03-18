<%@page import="com.lowlist.Dto.Dto_friend"%>
<%@page import="com.lowlist.BoardDao.Dao"%>
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
    String searchName = request.getParameter("userName");
    String searchTag = request.getParameter("userTag");

    Dao dao = new Dao();
    Dto_friend posts = null;
    
    if (searchName != null && searchTag != null) {
        posts = dao.listSearch(searchName, searchTag);

        // 검색 결과가 맞으면 출력
        if (posts != null) {
        	System.out.println("성공");
    %>
            <%= searchName %>#<%= searchTag %>
            <form action="friend_plus_proc.jsp">
                <input name ="searchName" type="hidden" value="<%= searchName %>">
                <input name ="searchTag" type="hidden" value="<%= searchTag %>">
                <input type="submit" value="친구추가">
            </form>
            
            <form action="friend_list.jsp">
                <input type="submit" value="취소">
            </form>
    <%
        } else {
        	System.out.println("실패1");
            // 검색 결과가 없을 때 friend_list.jsp로 리다이렉트
            response.sendRedirect("friend_list.jsp?msg=null");
        }
    } else {
    	System.out.println("실패2");
        response.sendRedirect("friend_list.jsp?msg=null");
    }
    %>
</body>
</html>
