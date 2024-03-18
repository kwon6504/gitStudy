package com.peisia.c.test5;

import com.peisia.c.util.Cw;

public class Disp {
	String x = "x";

	final static String DOT = "■";
	final static int DOT_COUNT = 30;

	public static void line() {
		for (int i = 0; i < DOT_COUNT; i++) {
			Cw.w(DOT);
		}
		Cw.wn();
	}

	public static void title() {
		line();
		Cw.wn("고양이 카페");
		line();
	}
}
