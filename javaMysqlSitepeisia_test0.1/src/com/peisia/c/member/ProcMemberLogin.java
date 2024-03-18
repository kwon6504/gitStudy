package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcMemberLogin {
	public static String run() {
		Cw.wn("======== 로그인 ========");
		String id="";
		String pw="";
		while(true) {
			id = Ci.r("아이디");
			if(id.length()>0) {
				break;
			} else {
				Cw.wn("유효하지 못한 입력 입니다.");
			}
		}
		
		while(true) {
			pw = Ci.r("비밀번호");
			if(pw.length()>0) {
				break;
			} else {
				Cw.wn("유효하지 못한 입력 입니다.");
			}
		}
		
		if(Db.isProcLogin(id, pw)) {
			return id;
		} else {
			Cw.wn("로그인 실패");
			return null;
		}
	}
}
