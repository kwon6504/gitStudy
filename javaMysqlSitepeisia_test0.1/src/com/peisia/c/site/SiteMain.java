package com.peisia.c.site;

import com.peisia.c.board.ProcBoard;
import com.peisia.c.member.ProcMemberLogin;
import com.peisia.c.member.ProcMemberRegister;
import com.peisia.c.site.display.DispSite;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class SiteMain {
	static private String cmd = "";
	static public String LoginedId = null;

	public static void run() {
		Db.dbInit();

		loop: while (true) {
			DispSite.entranceTitle();
			if (LoginedId == null) {
				cmd = Ci.r("[r]회원가입 [l]로그인 [e]프로그램종료");
			} else {
				Cw.wn(LoginedId + " 고객님 환영합니다. ");
				cmd = Ci.r("[l]로그아웃 [b]자유게시판 [t]장터게시판 [a]관리자 [e]프로그램종료");
			}
			switch (cmd) {
			case "r":
				if (LoginedId == null) {
					ProcMemberRegister.run();
				} else {
					Cw.wn("장난치지마세요.");
				}
				break;

			case "l":
				if (LoginedId == null) {
					LoginedId = ProcMemberLogin.run();
				} else {
					Cw.wn("[로그아웃 됨]");
					LoginedId = null;
				}
				
			case "e":
				Cw.wn("프로그램 종료");
				break;
				
			case "b":
				if(LoginedId == null) {
					Cw.wn("장난치지마세요.");
				} else {
					Db.tableName = "board";
					ProcBoard.run();
				}
				break;
			}
			
			
		}
	}
}
