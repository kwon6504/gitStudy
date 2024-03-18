package com.peisia.c.borad;

import java.util.Scanner;

import com.peisia.c.Sql.Load;
import com.peisia.util.Cw;

public class ProcMenuDel {
	static void run() {
		Scanner sc = new Scanner(System.in);
		Cw.wn("삭제할 글 번호");
//		System.out.println("삭제할 글번호를 입력해주세요:");
		loop : while (true) {
			try {
				int delNo = Integer.parseInt(sc.next());
				String read = "select * from board where b_no=" + delNo;
				String writer = Load.dbexecuteQuery(read);
				String b_id = Load.dbexecuteQueryId(read, writer);
				if (Member.idname.equals(b_id)) {
					Load.dbExecuteUpdate("update board set b_del = 1 where b_id=" + b_id + " and " + "b_no=" + delNo);
				} else {
					Cw.wn("권한이 없습니다.");
				}
				break loop;
			} catch (NumberFormatException e) {
				System.out.println("알맞는 번호를 입력해주세요.");
			}
		}
//		Cw.wn("글삭제");
//		String cmd = Ci.r("삭제할 글 번호");
//		//삭제할 글 찾기
//		int index = 0;
//		for(int i=0; i<Data.posts.size(); i++) {
//			if(cmd.equals(Data.posts.get(i).instanceNo+"")) {
//				index = i;
//			}
//		}
//		//삭제하기
//		Data.posts.remove(index);
//		Cw.wn("글 수:"+Data.posts.size());
	}
}
