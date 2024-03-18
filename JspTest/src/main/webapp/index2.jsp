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
	request.setCharacterEncoding("UTF-8");

	
	
	String id = (String)session.getAttribute("idkey");
	String pw = (String)session.getAttribute("pwkey");
	
	

%>
<%=id%>
<%=pw%>
	

</body>
</html>
