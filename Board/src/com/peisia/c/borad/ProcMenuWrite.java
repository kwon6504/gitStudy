package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.data.Post;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;

public class ProcMenuWrite {
	static void run() {
		Cw.wn("쓰기");
		String title;
		while (true) {
			title = Ci.rl("글제목");
			if (title.length() > 0) {
				break;
			} else {
				Cw.wn("장난x");
			}
		}

		String content;
		while (true) {
			content = Ci.r("글내용");
			if (content.length() > 0) {
				break;
			} else {
				Cw.wn("장난x");
			}
		}

		String writer;
		while (true) {
			writer = Ci.r("작성자");
			if (writer.length() > 0) {
				break;
			} else {
				Cw.wn("장난치지마");
			}
		}
		Post p = new Post(title, content, writer, 0);
		Data.posts.add(p);
		Cw.wn("글 작성됨");
	}
}
