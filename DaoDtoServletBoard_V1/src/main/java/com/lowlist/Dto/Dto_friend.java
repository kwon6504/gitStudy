package com.lowlist.Dto;

public class Dto_friend {
	public String My_User_no = null;
	public String Friend_User_no = null;
	public String Frined_NAME = null;
	
	public Dto_friend(String my_User_no, String friend_User_no) {
		My_User_no = my_User_no;
		Friend_User_no = friend_User_no;
	}

	public Dto_friend(String frined_NAME) {
		Frined_NAME = frined_NAME;
	}
	
}
