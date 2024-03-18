package com.MangoChat.Servlet;

import com.MangoChat.ChatDB.C_Dao;
import com.MangoChat.ChatDB.C_Dto;
import com.MangoChat.FriendDB.F_Dao;
import com.MangoChat.LoginDB.L_Dao;
import com.MangoChat.LoginDB.L_Dto;
import com.MangoChat.RoomDB.R_Dao;
import com.MangoChat.util.Util;

public class Service {
public L_Dao L = new L_Dao();
public C_Dao C = new C_Dao();
public R_Dao R = new R_Dao();
public F_Dao F = new F_Dao();
public Util U = new Util();


public boolean idck(String id, String pw) {
		return L.loginCk(id,pw);
	}
	public L_Dto idPw(String id, String pw) {
		return L.login(id,pw);
	}
	
	public void chatting(String roomNo,String chat,String userNo) {
		C.chatting(roomNo, chat, userNo);
	}
	
	public C_Dto chattinglist(String roomNo) {
	
		if(roomNo == null) {
			return null;
		}
	C_Dto post = null;
		return post;
	}
		
	public void signUp(L_Dto roomNo) {
		L.sigbUp(roomNo);
	}
	
	public boolean signUpIdCk(String id) {
		return L.signUpIdCk(id);
	}
	
	public L_Dto chatName(String userNo) {
		return U.userName(userNo);
	}
	// 친구 삭제
	public void friendDel(String userNo,String friendNo) {
		F.friendDel(userNo,friendNo);
	}
	// 친구 고유번호 리턴문
	public String friendUserNo(String name,String tag) {
		return F.friendUserNo(name, tag);
	}
	// 친구 신청 체크박스로 보내기
	public void friendAddCheckBox(String name,String tag,String No) {
		F.friendCheckBox(name, tag , No);
	}
	//친구 추가
	public void friendAdd(String userNo,String friendNo) {
		F.friendAdd(userNo,friendNo);
	}
	public boolean CheckBoxBoolean(String name,String tag,String No) {
		return F.friendCheckBoxBoolean(name,tag,No);
	}
}
