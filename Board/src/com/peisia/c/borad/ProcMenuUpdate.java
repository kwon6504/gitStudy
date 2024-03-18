package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.data.Post;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;

public class ProcMenuUpdate {
	static void run() {
		Cw.wn("업데이트");
		String cmd = Ci.r("수정할 글 번호");
		
		for(Post p:Data.posts) {
			if(cmd.equals(p.instanceNo+"")) {
				String content = Ci.rl("수정 할 글 내용");
				p.content = content;
				Cw.wn("글 수정 됨");
			}
		}
	}
}
