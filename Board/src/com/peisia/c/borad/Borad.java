package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.display.Disp;

public class Borad {
	public static final String TITLE = "고양이 게시판";
	static void run() {
		Data.loadData();
		Disp.title();
		ProcMenu.run();
	}
}
