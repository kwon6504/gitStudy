<%@page import="java.util.ArrayList"%>
<%@page import="com.MangoChat.FriendDB.F_Dto"%>
<%@page import="com.MangoChat.FriendDB.F_Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	친구신청
	<hr>
	<%
	String myUserNo = (String) session.getAttribute("userNo");
	%>
	<%
	F_Dao f_dao = new F_Dao();
	ArrayList<F_Dto> friendCheck = f_dao.friendPlusCheck(myUserNo);
	for (int i = 0; i < friendCheck.size(); i = i + 1) {
		F_Dto friendInfo = f_dao.friendInfo(friendCheck.get(i).Frined_NAME);
	%>
	<%=friendInfo.Frined_NAME%>#<%=friendInfo.Tag%>
	<form action="/chat/friendAdd" method="post">
		<!-- form 으로 묶은다음 매서드를 post로 한 뒤 submit 버튼 출력 후 값을 히든처리해서 전송 -->
		<input type="hidden" name="friendName" value="<%=friendInfo.Frined_NAME%>"> 
		<input type="hidden" name="friendTag" value="<%=friendInfo.Tag%>"> 
		<input type="submit" name="friendNo" value="수락">
	</form>
	<%
	}
	%>
</body>
</html>