package com.peisia.c.board.data;

import java.util.ArrayList;

public class Data {
	static public ArrayList<Post> posts; // = new ArrayList<>(); 이렇게도 가능하다.
	static public void loadData() { //초기화를 하기 위해서
		posts = new ArrayList<>(); // arrayList.clear(); 효과를 가지고 온다. 
		//함수 loadData() 사용할때마다 Date초기화가 가능하다.
	}
}
