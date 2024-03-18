package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.data.Post;
import com.peisia.c.util.Cw;

public class ProcMenuList {
	static void run() {
		Cw.wn("리스트");
		for (Post p : Data.posts) {
			p.infoForList();
			Cw.wn();
		}
	}
}
