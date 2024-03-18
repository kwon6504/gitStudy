package com.peisia.c.cafe;

import com.peisia.util.Cw;

public class Disp {
	String x = "x";

	final static String DOT = "☆";
	final static int DOT_COUNT = 10;

	public static void line() {
		for (int i = 0; i <= DOT_COUNT; i = i + 1) {
			Cw.w(DOT);
		}
		Cw.wn();
	}
	
	public static void title() {
		line();
		Cw.wn("날먹카페");
		line();
	}
}
