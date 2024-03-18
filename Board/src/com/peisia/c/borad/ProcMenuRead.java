package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.data.Post;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;

public class ProcMenuRead {
	static void run() {
		Cw.wn("읽기");
		String cmd = Ci.r("읽을 글 번호");
		for (Post p : Data.posts) {
			if(cmd.equals(p.instanceNo+"")) {
				//equals는 비교하는 배열
				p.infoForRead();
			}
		}
	}
}