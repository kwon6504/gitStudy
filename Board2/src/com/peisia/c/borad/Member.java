package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Signup;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class Member {
	public static String idname;

	static void run() {

		while (true) {
			String cmd = Ci.r("[1,회원가입/2,로그인/e.종료]");
			switch (cmd) {
			case "1": // 회원가입

				Cw.wn("회원가입");
				Cw.wn("아이디를 입력하세요.");
				String id;
				end: while (true) {

					while (true) {
						id = Ci.r("아이디");
						if (id.length() > 0) {
							break;
						} else {
							Cw.wn("유효하지 못합니다.");
						}
					}
					if (Load.dbPostCount(id)) {
						break end;
					} else {
						Cw.wn("중복된 아이디 입니다.");
						return;
					}
				}

				String pw;
				while (true) {
					pw = Ci.rl("비밀번호");
					if (pw.length() > 0) {
						break;
					} else {
						Cw.wn("유효하지못한패스워드입니다.");
						return;
					}
				}
				String name;
				while (true) {
					name = Ci.rl("닉네임");
					if (name.length() > 0) {
						break;
					} else {
						Cw.wn("잘못된 이름입니다.");
					}
				}
				idname = id;

				Signup s = new Signup(id, pw, name);
				Data.sign.add(s);
				Cw.wn("회원가입완료");

				String sql = String.format("insert into members (u_id, u_pw, u_name) values ('%s', '%s', '%s');", id,
						pw, name);
				Load.writer_run(sql);
				break;

			case "2":
				Cw.wn("로그인");
				String loginId = Ci.r("아이디");
				String loginPw = Ci.rl("비밀번호");

				if (!Load.dbPostCount(loginId, loginPw)) {
					Cw.wn("로그인 성공!");
					Member.idname = loginId;
					ProcMenu.run();
				} else {
					Cw.wn("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
				}
				break;
//			    String loginId = Ci.r("아이디");
//			    String loginPw = Ci.rl("비밀번호");
//
//			    if (Login(loginId, loginPw)) {
//			        Cw.wn("로그인 성공!");
//			        Member.idname = loginId;
//
//					ProcMenu.run();
//			    } else {
//			        Cw.wn("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
//			    }
//			    break;

			case "e":
				return;

			}
		}

	}
}
