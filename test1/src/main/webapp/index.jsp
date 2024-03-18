<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.jsp.Q04.Cat" %>
<%@ page errorPage="error.jsp" %>    

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 		String a = "고양이";
 	for(int i=1;i<=3;i++){
	%>
    <img src ="cat.jpg" alt="고양이" id=cat>
	<%} %>
<	<br>
	내 이름은 <%=a %> 입니다.
	<br>
	hellow world !!!
	<br> -->
	<%ArrayList<String> b = new ArrayList<>();
 	b.add("고양이");
	b.add("개");
 	b.add("너굴맨");
 	for(int i=0; i<b.size(); i++){
	%>
	<%=b.get(i) %> <!-- 표현태그 -->
	<%} %>
 	<br>
	<%Cat cat = new Cat(); %>
	<%=cat.name %>
<!-- 	request 요청을 담는다. -->
	<%
 	request.setCharacterEncoding("UTF-8");	// 이거 안하면 한글 깨짐.
 	String s = request.getParameter("tel");
 	out.println(s);	// 1.이걸로 출력하거나
%>
입력한 전화번호:<%=s%>2. 이걸로 출력

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 --%>
<% 
	response.sendRedirect("http://naver.com");
%>
	
</body>
</html>