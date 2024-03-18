package com.MangoChat.RoomDB;

public class R_Dto {
	
	public String userNo;
	public String roomNo;
	public String roomName;
	public String bossNo;
	public String userMax;
	public R_Dto( String roomNo,  String bossNo, String roomName,String userMax) { // 방 설정 
		this.roomNo = roomNo;
		this.bossNo = bossNo;
		this.roomName = roomName;
		this.userMax = userMax; // <= 인트로 변환해서 사용해야함
	}
	
	
	public R_Dto(String userNo, String roomNo) { // 룸 들어가는거
		this.userNo = userNo;
		this.roomNo = roomNo;

	}

}
