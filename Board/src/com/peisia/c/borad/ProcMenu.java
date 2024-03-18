package com.peisia.c.borad;

import com.peisia.c.display.Disp;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;

public class ProcMenu {
	static void run() {
		Disp.menuMain();
		loop: while (true) {
			String cmd = Ci.r("명령");
			switch (cmd) {
			case "1":
				ProcMenuList.run();
				break;
			case "2":
				ProcMenuRead.run();
				break;
			case "3":
				ProcMenuWrite.run();
				break;
			case "4":
				ProcMenuDel.run();
				break;
			case "5":
				ProcMenuUpdate.run();
				break;
			case "e":
				Cw.wn("프로그램 종료");
				break loop;
			default:
				Cw.wn("장난x");
				break;
			}
		}
	}
}
