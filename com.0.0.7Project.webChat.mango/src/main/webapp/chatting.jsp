<%@page import="com.MangoChat.util.Util"%>
<%@page import="com.MangoChat.LoginDB.L_Dto"%>
<%@page import="com.MangoChat.ChatDB.C_Dto"%>
<%@page import="com.MangoChat.ChatDB.C_Dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/chatRoom.css">
<meta charset="UTF-8">
<title>채팅창</title>
</head>
<body>
<script>
        function addContent() {
            // 화면을 아래로 스크롤
            window.scrollTo(0, document.body.scrollHeight);
        }
        
        function handleKeyPress(event) {
            // Enter 키 (keyCode 13)를 누를 때 글 추가 함수 호출
            if (event.keyCode === 13) {
                addContent();
            }
    </script>
	<div id="warp">
		<div id="ChatArea">
			<%
			String roomNo = request.getParameter("roomNo");
			if (roomNo != null || !roomNo.equals(null)) {
				C_Dao dao = new C_Dao();
				ArrayList<C_Dto> chatList = dao.chattingList(roomNo);
				String myUserNo = (String) session.getAttribute("userNo");
			%>
			<div id="chattingList">
				<%
				if (chatList.size() > 0) {
				Util util = new Util();
					for (C_Dto a : chatList) {
						L_Dto name = util.userName(a.userNo);
						if (!a.userNo.equals(myUserNo)) {
				%>

				<!-- 				유저 채팅 창 -->
				<div>
					<div class="Chat_main_box">
						<div class="Chat_user_img">
							<!-- 							<img alt="#" src="관심이.jpg"> -->
							<img
								src="https://i.ibb.co/xXm2sGH/1-Gx-B1-PLCKMEp-GN6f-Fy-Nbp-LBa-DOt-Cq09et-SE-B97-Sw-I19-He-N1pjw-Rp-giymw-Mv-Xgd-U3k4o-TVw-Nf4ctyon.webp"
								alt="1-Gx-B1-PLCKMEp-GN6f-Fy-Nbp-LBa-DOt-Cq09et-SE-B97-Sw-I19-He-N1pjw-Rp-giymw-Mv-Xgd-U3k4o-TVw-Nf4ctyon"
								border="0">
							<!-- 프로필이미지 연동 -->
						</div>
						<div class="Chat_user_box">
							<div class="Chat_user_names_box">
								<h1><%=name.userName%>#<%=name.userTag %></h1>
								<%=a.time%>
							</div>
							<div class="Chat_User_Main_Chat">
								<%=a.chat%>
							</div>
						</div>
					</div>
				</div>
				<!-- 				유저 채팅 창 -->
				<%
				} else {
				%>
				<!-- 				내 채팅 창 -->
				<div>
					<div class="Chat_MY_main_box">
						<div class="Chat_MY_user_box">
							<div class="Chat_MY_user_names_box"><%=a.time%></div>
							<div class="Chat_MY_User_Main_Chat"><%=a.chat%></div>
						</div>
					</div>
				</div>
				<!-- 				내 채팅 창 -->
				<%
				}
				}
				} else {
				%>
				채팅이 없습니다.
				<%
				}
				}
			%>
			</div>
		</div>

		<div id="Chat_Input_area">
			<!-- 채팅 -->
			<form action="/chat/chatting" method="get">
				<input type="hidden" name="roomNo" value=<%=roomNo%>>
				<div class="textarea">
					<!-- 					<textarea rows="" name="chat" cols="" placeholder="채팅을 보내주세요"></textarea> -->
					<input class="inputvalue" type="text"
						onkeypress="handleKeyPress(event)" name="chat" placeholder="채팅창">
				</div>
			</form>
		</div>
		<!-- 채팅-->

	</div>
</body>
</html>