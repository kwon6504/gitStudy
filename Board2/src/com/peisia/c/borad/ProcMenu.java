package com.peisia.c.borad;

import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenu {
	static void run() {
        Cw.wn("게시판");
		//타이틀
//		Disp.title();
		//게시판 메인
		loop:
			
			while(true) {
				
				String cmd = Ci.r("명령[1.글리스/2.글읽기/3.글쓰기/4.글삭제/5.글수정/6.삭제글복구/e.종료]");
				switch(cmd) {
				case "1": //리스트
					ProcMenuList.run();
					break;
				case "2": //읽기
					ProcMenuRead.run();
					break;
				case "3": //글쓰기
					ProcMenuWriter.run();
					break;
				case "4": //삭제
					ProcMenuDel.run();
					break;
				case "5": //글수정
					ProcMenuUpdate.run();
					break;
				case "6": //삭제한글 북구
					ProcMenuRecover.run();
					break;
				case "e": //종료
					break loop;
				}
			}
	}
}
