package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuRead {
	static void run() {
		Cw.wn("읽기");
		String readNo = Ci.r("읽을 글 번호를 입력해주세요: ");
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		try {
			String read = "select*from board where b_no=" + readNo;
			Load.dbexecuteQuery(read);
			Load.dbExecuteUpdate("update board set b_hit=b_hit+1 where b_no=" + readNo);
			ProcReply.list(Integer.parseInt(readNo)); // Integer.parseInt 문자열을 정수로 바꾸는 함수;
			loop: while (true) {
				String cmd = Ci.r("명령:[x.나가기, r.댓글쓰기]");
				switch (cmd) {
				case "x":
					break loop;
				case "r":
					ProcReply.write(Integer.parseInt(readNo));
					break;
				default:
					Cw.wn("없는 명령어 입니다.");
				}
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}

//		for (Post p : Data.posts) {
//			if (cmd.equals(p.instanceNo + "")) {
//				p.infoForRead();
//				p.hit++;
//				String content;
//				while (true) {
//					content = Ci.rl("글내용");
//					if (content.length() > 0) {
//						break;
//					} else {
//						Cw.wn("장난치지마세요.");
//					}
//				}
//			}
//		}
