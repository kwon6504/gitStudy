package com.MangoChat.FriendDB;

public class F_Dto {
	public String My_User_no = null;
	public String Friend_User_no = null;
	public String Frined_NAME = null;
	public String Tag = null;
	public int aa = 0;
	
	public F_Dto(String my_User_no, String friend_User_no) {
		My_User_no = my_User_no;
		Friend_User_no = friend_User_no;
	}

	public F_Dto(String frined_NAME) {
		Frined_NAME = frined_NAME;
	}

	public String getFriend_User_no() {
		return Friend_User_no;
	}

	public void setFriend_User_no(String friend_User_no) {
		Friend_User_no = friend_User_no;
	}

	public F_Dto(String my_User_no, String frined_NAME, String tag) {
		My_User_no = my_User_no;
		Frined_NAME = frined_NAME;
		Tag = tag;
	}
	
	
	
	
	
}
