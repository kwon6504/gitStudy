<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>原神</title>
</head>
<body>

<!-- param 보내는 명령어 ,flush 기본값 false 출력할때 버퍼(출력하기전에 모아두는 공간)라는 공간을 만들고 거기서 출력을 하는 명령어-->
<jsp:include page="common.jsp" flush="true">
	<jsp:param name="x" value="11" />
	<jsp:param name="y" value="22" />
</jsp:include>

개2



</body>
</html>