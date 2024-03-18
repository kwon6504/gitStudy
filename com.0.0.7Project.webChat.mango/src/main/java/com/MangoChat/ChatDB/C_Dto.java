package com.MangoChat.ChatDB;

public class C_Dto {

	public String roomNo;
	public String userNo;
	public String chat;
	public String time;
	

	public C_Dto(String roomNo,String userNo, String chat, String time) {
		this.roomNo = roomNo;
		this.userNo = userNo;
		this.chat = chat;
		this.time = time;
	}
	public C_Dto(String userNo,String chat, String time) {
		this.userNo = userNo;
		this.chat = chat;
		this.time = time;
	}

	
	
}
