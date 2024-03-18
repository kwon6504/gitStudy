package com.peisia.c.borad;

import java.util.Scanner;

import com.peisia.c.Sql.Load;
import com.peisia.c.Sql.Save;
import com.peisia.util.Cw;

public class ProcMenuRecover {
	static void run() {
		int ck;
		Scanner sc = new Scanner(System.in);
		Cw.wn("삭제한 글 복원");
		String re = sc.next();
		ck = Save.dbExecuteQuery("SELECT * FROM board WHERE B_ID LIKE '" + Member.idname + "' AND B_no = " + re, "b_del", 0);
//		ck = Load.dbexecuteQuery("select");
		if (ck == 1) {
			String read = "select * from board where b_no=" + re;
			String writer = Load.dbexecuteQuery(read);
			String b_id = Load.dbexecuteQueryId(read, writer);
			if (Member.idname.equals(b_id)) {
				ck=Load.dbExecuteUpdateRe("update board set b_del=0 where b_no=" + b_id + " and b_del=1");
				Cw.wn("복원되었습니다.");
				return;
			} else {
				Cw.wn("권한이 없습니다.");
			}
		} else {
			Cw.wn("이미 있는 글입니다.");
		}
//		sc.close();
	}
}
