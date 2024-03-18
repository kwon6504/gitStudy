package com.MangoChat.Servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MangoChat.FriendDB.F_Dao;
import com.MangoChat.LoginDB.L_Dto;
import com.MangoChat.Servlet.Service;

@WebServlet("/chat/*")
public class Controller extends HttpServlet {

	Service service;
	String nextPage;
	String id;
	String pw;

	public void init() throws ServletException {
		service = new Service();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		if (action != null) {
			switch (action) {
			case "/signUp":
				nextPage = "/signUp.jsp";
				break;
			case "/signUp_proc":
				id = String.format(request.getParameter("id"));
				pw = String.format(request.getParameter("pw"));
				String pwRe = String.format(request.getParameter("pwRe"));
				String name = String.format(request.getParameter("name"));
				String regex = ".*[\\p{Punct}\\s].*";
				try {
					if (id.length() <= 0 || pw.length() <= 0 || pwRe.length() <= 0 || name.length() <= 0) {
						nextPage = "/signUp.jsp?mag=null";
					} else if (id.matches(regex) || pw.matches(regex) || pwRe.matches(regex) || name.matches(regex)) {
						nextPage = "/signUp.jsp?mag=*";
					} else if (!pw.equals(pwRe)) {
						nextPage = "/signUp.jsp?mag=pw";
					} else if (service.signUpIdCk(id)) {
						L_Dto join = new L_Dto(id, pw, name);
						service.signUp(join);
						nextPage = "/login.jsp";
					} else {
						nextPage = "/signUp.jsp?mag=id";
					}
				} catch (NullPointerException e) {
					session.setAttribute("mag", "null");
					nextPage = "/signUp.jsp?mag=null";
				}
				break;
			case "/login_proc":
				id = String.format(request.getParameter("id"));
				pw = String.format(request.getParameter("pw"));
				if (service.idck(id, pw)) {
					L_Dto idPw = service.idPw(id, pw);
					session.setAttribute("userNo", idPw.userNo);
					session.setAttribute("userName", idPw.userName);
					session.setAttribute("userTag", idPw.userTag);
					nextPage = "/chat/index";
				} else {
					nextPage = "/chat/login";
				}
				break;
			case "/chatting":
				nextPage = "/chat/index";
				String chatContent = request.getParameter("chat");
				String roomNo = request.getParameter("roomNo");
				String userNo = (String)session.getAttribute("userNo");
				service.chatting(roomNo, chatContent, userNo);
				break;
			case "/index":
				nextPage = "/index.jsp";
				request.setAttribute("roomNo", request.getParameter("roomNo"));
				break;
			case "/login":
				nextPage = "/login.jsp";
				break;
			// 친구찾기
			case "/friendListSearch":
				nextPage = "/index.jsp";
				F_Dao f_dao = new F_Dao();
				// 로그인 세션 처리한 값 받아오기
				String myUserNo = (String)session.getAttribute("userNo");
				// 겟방식 form text 으로 전송받은 값 지정
				String searchName = request.getParameter("searchName");
				String searchTag = request.getParameter("searchTag");
				// 조건문1 태그란에 아무것도 안넣을때 처리
				if(searchTag.equals("") && !searchName.equals("")) {
					ArrayList<L_Dto> listSearch = f_dao.listSearch(searchName,myUserNo);
					session.setAttribute("listSearch",listSearch); // 해당되는값 세션처리
					session.setAttribute("taglistSearch",null); // null값으로 초기화 안하면 세션값이 그대로 남아서 버그발생함.
				// 조건문2 닉네임,태그란에 전부 넣었을때 처리
				} else if(!searchTag.equals("") && !searchName.equals("")){
					ArrayList<L_Dto> tagListSearch = f_dao.tagListSearch(searchName, searchTag , myUserNo);
					session.setAttribute("taglistSearch",tagListSearch); // 해당되는값 세션처리
					session.setAttribute("listSearch",null); // null값으로 초기화 안하면 세션값이 그대로 남아서 버그발생함.
				} else {
					System.out.println("바보");
					// 예외처리 확인용
				}
				// 전송값 확인용
				System.out.println("이름임:"+searchName);
				System.out.println("태그임:"+searchTag);
				
				break;
				
			case "/roomJoin":

				break;
				
			
			}
			RequestDispatcher n = request.getRequestDispatcher(nextPage);
			n.forward(request, response);

		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		String friendName = "";
		String friendTag = "";
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		if (action != null) {
			switch (action) {
			
			// 친구삭제
			case "/friendDel":
				nextPage ="/index.jsp";
				// Post 방식으로 삭제버튼을 누르면 자동으로 해당되는 값 전송
				friendName = request.getParameter("friendName");
				friendTag = request.getParameter("friendTag");
				
				// 친구 고유번호 뽑아오기
				String friendNo = service.friendUserNo(friendName, friendTag);
				
				//삭제 실행
				service.friendDel((String)session.getAttribute("userNo"),friendNo);
				break;
			// 친구신청
			case "/requestFriend":
				nextPage ="/index.jsp";
				// Post 방식으로 친구신청 버튼을 누르면 자동으로 해당되는 값 전송
				friendName = request.getParameter("friendName");
				friendTag = request.getParameter("friendTag");
				// 내 고유번호 뽑아오기
				String myUserNo = (String)session.getAttribute("userNo");
				// 체크박스에 넣기
				if(service.CheckBoxBoolean(friendName,friendTag,myUserNo)) {
				service.friendAddCheckBox(friendName, friendTag, myUserNo);
				System.out.println("친추 이름확인용:"+friendName);
				System.out.println("친추 태그확인용:"+friendTag);
				System.out.println("친추 번호확인용:"+myUserNo);
				}else {
					System.out.println("바보");
				}
				break;
				
				// 친구 추가
			case "/friendAdd":
				nextPage ="/index.jsp";
				// Post 방식
				friendName = request.getParameter("friendName");
				friendTag = request.getParameter("friendTag");
				
				// 친구 고유번호 뽑아오기
				String friendNo2 = service.friendUserNo(friendName, friendTag);
				
				//친구 추가 실행
				service.friendAdd((String)session.getAttribute("userNo"),friendNo2);
				break;
		
				}
			RequestDispatcher n = request.getRequestDispatcher(nextPage);
			n.forward(request, response);

			}
		}
}
