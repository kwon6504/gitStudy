package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcMemberRegister {
	static private String cmd = "";
	public static String idname;

	public static void run() {
		Cw.wn("======== 회원가입 ========");
		String id = "";
		String pw = "";
		loop: while (true) {
			while (true) {
				id = Ci.r("아이디");
				if (id.length() > 0) {
					break;
				} else {
					Cw.wn("아무 입력이 없습니다.");
				}
			}
			if (Db.dbPostCount(id)) {
				break loop;
			} else {
				Cw.wn("이미 존재하는 아이디 입니다.");
				return;
			}
		}

		while (true) {
			pw = Ci.r("비밀번호");
			if (pw.length() > 0) {
				break;
			} else {
				Cw.wn("비밀번호를 입력해주세요.");
			}
		}
		
		idname = id;

		Db.dbExecuteUpdate("insert into member valuse('" + id + "','" + pw + "')");
		Cw.wn("[가입완]");
	}
}
