package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuUpdate {
	static void run() {
		int sc;
		Cw.wn("업데이트");
		
		while (true) {
			String cmd = Ci.rl("수정할 글 번호");
			if(cmd == "0") {
				return;
			}
			try {
				sc = Integer.parseInt(cmd);
				break;
			} catch (NumberFormatException e) {
				Cw.wn("올바른 숫자 형식이 아닙니다.");

			}
		}
		
		
//		if(sc != Save.dbExecuteQuery("select*from board where b_no = " + sc,"b_no",0)) {
//			Cw.wn("없는 글 입니다.");
//			return;
//		}
		if(Load.dbPostCount(sc)) {
			Cw.wn("존재하지 않는 글입니다.");
			return;
		}
		String read = "select * from board where b_no=" + sc;
		String writer= Load.dbexecuteQuery(read);
		String b_id = Load.dbexecuteQueryId(read, writer);
//		String b_id = null;
//		try {
//			Load.result = Load.st.executeQuery(read);
//			while (Load.result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
//				b_id = Load.result.getString("b_id");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		if(Member.idname.equals(b_id)) {
			String title = Ci.rl("수정할 제목");
			String text = Ci.rl("수정할 내용");
			Load.dbExecuteUpdate("update board set b_title='" + title + "', b_text='" + text + "' where b_no =" + sc);
			
			Cw.wn("수정 완료");
			
		} else  {
			Cw.wn("수정권한이 없습니다");
			return;
		}
		
		
		
//		for(Post p:Data.posts) {
//			if(cmd.equals(p.instanceNo+"")) {
//				String content = Ci.rl("수정할 내용");
//				p.content = content;
//				Cw.wn("수정 완료");
//			}
//		}
	}
}
