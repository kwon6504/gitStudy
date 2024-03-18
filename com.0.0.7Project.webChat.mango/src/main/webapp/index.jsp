<%@page import="com.MangoChat.FriendDB.F_Dao"%>
<%@page import="com.MangoChat.FriendDB.F_Dto"%>
<%@page import="com.MangoChat.LoginDB.L_Dto"%>
<%@page import="com.MangoChat.RoomDB.R_Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.MangoChat.util.Util"%>
<%@page import="com.MangoChat.RoomDB.R_Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 로비 메인</title>
<link rel="stylesheet" href="/index.css">
<link rel="stylesheet" href="/chatRoom.css">
</head>
<body>
	<%
	String myUserName = (String) session.getAttribute("userName");
	String myUserNo = (String) session.getAttribute("userNo");
	String userTag = (String) session.getAttribute("userTag");
	String roomNo = request.getParameter("roomNo");
	String cookieName = "myCookie";
	Cookie cookie = new Cookie(cookieName, myUserNo);
	cookie.setMaxAge(3);
	response.addCookie(cookie);
	%>
	<div id="main">
		<header id="top"></header>
		<section id="mid">
			<div id="midLeft">
				<div id="chatTop">
					<div id="topText">채팅목록 ▼</div>
				</div>
				<%
				R_Dao dao = new R_Dao();
				Util util = new Util();
				ArrayList<R_Dto> roomList = dao.roomList(myUserNo);
				if (roomList.size() > 0) {
					for (R_Dto list : roomList) {
						L_Dto name = util.userName(list.bossNo);
						int count = util.roomUserCount(list.roomNo);
				%>
				<div id="roomNo" onclick="chat('<%=list.roomNo%>')">
					방이름:<%=list.roomName%><br> 방장 :<%=name.userName%>#<%=name.userTag%>
					방인원:<%=count%>/<%=list.userMax%>
				</div>
				<script>
					function chat(roomNo) {
						window.location.href = "/chat/index?roomNo=" + roomNo;
					}
				</script>
				<%
				}
				} else {
				%>채팅방이 없는 아싸입니다<%
				}
				%>

				<div id="chatRoom"></div>
			</div>

			<div id="midCenter">

				<div id="midChat">
					<%
					if (roomNo != null && !roomNo.equals(null)) {
					%>
					<jsp:include page="chatting.jsp" flush="true">
						<jsp:param name="roomNo" value="<%=roomNo%>"></jsp:param>
					</jsp:include>
					<%
					} else {
					%>
					채팅방 접속하지않음
					<%
					}
					%>

				</div>
			</div>
			<div id="midRight">
				<div id="midProfile">
					<img id="ProfileImage"
						src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
					<div id="ProfileText"><%=myUserName%>님 반갑습니다.
					</div>
				</div>
				<div id="midFriend">
					<div id="friendtop">
						<div id="friendText">친구목록▼ 친구찾기▼ 
						<a href="/friendAdd.jsp">알림▼</a>
						</div>
						<!-- 이거 토글기능 넣고싶음 친구목록,친구찾기,신청받은리스트 등등-->
					</div>

					<% 
					// 친구목록 표기 로그인시 자동으로 나오게 만들었음.
					F_Dao f_dao = new F_Dao();
					ArrayList<F_Dto> friendlist = f_dao.friendList(myUserNo); 
					%>
					<hr>
					<%= "현재친구:"+friendlist.size()+"명" %>
					<% 
					// 어레이리스트 (친구리스트) 를 불러와서 사이즈 만큼 for문 ++문 만들어서 자동출력
					for(int i=0;i<friendlist.size();i=i+1){
					F_Dto friendInfo = f_dao.friendInfo(friendlist.get(i).Frined_NAME);
					
					// 출력부분 및 삭제부분
					// post 방식으로 전송후 서블릿 컨트롤러 타서 처리하게 만들었음.
					%>
					<hr>
						<%=friendInfo.Frined_NAME %>#<%=friendInfo.Tag %>
						<form action="/chat/friendDel" method="post">
						<!-- form 으로 묶은다음 매서드를 post로 한 뒤 submit 버튼 출력 후 값을 히든처리해서 전송 -->
						<input type="hidden" name="friendName" value="<%= friendInfo.Frined_NAME %>">
       					<input type="hidden" name="friendTag" value="<%= friendInfo.Tag %>">
						<input type="submit" name="friendNo" value="삭제">
						</form>
					<%
					}
					// 친구검색기능창 get 방식으로 서블릿 컨트톨러 타서 세션 처리 및 예외 조건 처리해둠					
					%>
					<hr>
					<form action="/chat/friendListSearch">
					<input type="text" name = "searchName" placeholder="닉네임"># 
					<input type="text" name = "searchTag" placeholder="테그">
					<input type="submit" value="검색">
					</form>
					
					<% 
					// 이거 경고 무시해도됌 by.재원
					// 친구 검색 및 추가기능
					// 어레이리스트 세션처리
					ArrayList<L_Dto> search =(ArrayList<L_Dto>)session.getAttribute("listSearch");
					ArrayList<L_Dto> searchTag =(ArrayList<L_Dto>)session.getAttribute("taglistSearch");
					// 조건1 예외문 처음 시작할때 무조건 null값 가져와서 조건 넣어야지 발동되게 만들었음.
					// 서치만 처리(검색)
					if(searchTag == null && search != null){
						for(int i=0; i < search.size();i++){
							L_Dto searchRun = search.get(i);
							
					// 출력부분 및 친구추가기능
					// post방식으로 서블릿으로 전송 후 처리
					%>
						<hr>
						<%=searchRun.userName%>#<%=searchRun.userTag%>
						<form action="/chat/requestFriend" method="post">
						<!-- form 으로 묶은다음 매서드를 post로 한 뒤 submit 버튼 출력 후 값을 히든처리해서 전송 -->
						<input type="hidden" name="friendName" value="<%=searchRun.userName%>">
       					<input type="hidden" name="friendTag" value="<%=searchRun.userTag%>">
						<input type="submit" name="friendadd" value="친구신청">
						</form>
					<%
					}
					// 조건문2 태그만 처리
					}else if(searchTag != null){
						for(int i=0; i < searchTag.size();i++){
						L_Dto searchTagRun = searchTag.get(i);
						
					// 출력부분 및 친구추가기능
					// post방식으로 서블릿으로 전송 후 처리
					%>
						<hr>
						<%=searchTagRun.userName%>#<%=searchTagRun.userTag%>
						<form action="/chat/requestFriend" method="post">
						<!-- form 으로 묶은다음 매서드를 post로 한 뒤 submit 버튼 출력 후 값을 히든처리해서 전송 -->
						<input type="hidden" name="friendName" value="<%=searchTagRun.userName%>">
       					<input type="hidden" name="friendTag" value="<%=searchTagRun.userTag%>">
						<input type="submit" name="friendadd" value="친구신청">
						</form>
					<%		
						}
					}
					session.removeAttribute("listSearch");
					session.removeAttribute("taglistSearch");
					%>
					
				</div>
			</div>
		</section>
		<footer id="bot">
			<form action="/CreateRoom.jsp" method="get">
				<input name="roomName" placeholder="방 이름"> <input
					type="number" min="2" max="30" name="userMax" placeholder="최대방인원수">
				<input type="submit">
			</form>
		</footer>
	</div>


</body>
</html>