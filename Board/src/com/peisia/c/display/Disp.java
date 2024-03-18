package com.peisia.c.display;

import com.peisia.c.borad.Borad;
import com.peisia.c.util.Cw;

public class Disp {
	public static void title() {
		Cw.line();
		Cw.dot();
		Cw.space(7);
		Cw.w(Borad.TITLE);
		Cw.space(7);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
	public static void menuMain() {
		Cw.dot();
		Cw.w("[1.글 리스트/2.글읽기/3.글쓰기/4.글삭제/5.글수정/e.종료]");
		Cw.dot();
		Cw.wn();
	}
}
