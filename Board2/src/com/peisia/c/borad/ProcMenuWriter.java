package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuWriter {
	static void run() {
		Cw.wn("쓰기");
		// 글제목
		String title;
		while (true) {
			title = Ci.rl("글제목");
			if (title.length() > 0) {
				break;
			} else {
				Cw.wn("틀렸습니다.");
			}
		}

		// 글내용
		String content;
		while (true) {
			content = Ci.rl("글내용");
			if (content.length() > 0) {
				break;
			} else {
				Cw.wn("장난치지마세요.");
			}
		}
		
		int hit = 0;

//		// 작성자
//		String writer;
//		while (true) {
//			writer = Ci.rl("작성자");
//			if (writer.length() > 0) {
//				break;
//			} else {
//				Cw.wn("다시");
//			}
//		}
		
		//배열로 글 쓴거 등록
		Post p = new Post(0, title, content, Member.idname);
		Data.posts.add(p);
		Cw.wn("글 작성됨");
		String sql = String.format("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('%s','%s',now(),'%s',%d);", title, Member.idname, content, hit);
		Load.writer_run(sql);
		
	}
}
