package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuRead {
	static void run() {
		// todo
		// 임시
		Cw.wn("읽기임");
		String cmd = Ci.r("읽을 글 번호");
		for (Post p : Data.posts) {
			if (cmd.equals(p.instanceNo + "")) { // equals는 앞과 뒤가 동등한지 비교해주는 매서드
				p.infoForRead(); // equals는 ==과 뜻은 같지만 ==은 문자열 비교가 불가능하기때문에 equals를 쓴다.
//				break;
			}
		}
	}

}
