<%@page import="com.peisia.jsp.board.dto.Dto"%>
<%@page import="com.peisia.jsp.board.dao.DaoBoard"%>
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
Dto d = (Dto)request.getAttribute("post"); //post는 arraylist에서 가져온 객체
//String category = request.getParameter("category");
%>
카테고리: ${param.category}
<%-- <%=d.category%> --%>
<hr>
<%-- <%=d.no%>
<%=d.id%>
<%=d.title%>
<hr>
<%=d.text%> --%>

${post.no}
${post.id}
${post.title}
<hr>
${post.text}

<hr>
<a href="/board/del?category=${param.category}&no=${post.no}">삭제</a>
<a href="/board/edit_insert?category=${param.category}&no=${post.no}">수정</a>
<a href="/board/list?category=${param.category}">리스트로</a>
<a href="/">홈으로</a>
</body>
</html>