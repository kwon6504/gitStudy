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
	request.setCharacterEncoding("UTF-8"); // 이거 안하면 한글 깨짐.
	String nS[] = request.getParameterValues("hobby");
	//out.println(nS[0]);
	//out.println(nS[1]);

	if (nS != null) {
		for (int i = 0; i < nS.length; i++) {
			out.println(nS[i]);
		}
	}
	%>
	<!-- out.println(nS[i]);는 브라우저에 출력하는 함수 -->
	<%
	if (nS != null) {
	%>
	<%=nS.length%>
	<%
	for (int i = 0; i < nS.length; i++) {
	%>
	<%=nS[i]%>
	<%
	}
	} else {%>
	<a href='index2.html'>취미를 가지러 다시 가자</a>
	취미가 없다.	
	<% }
	%>



</body>
</html>