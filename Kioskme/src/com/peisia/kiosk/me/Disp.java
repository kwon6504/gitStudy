package com.peisia.kiosk.me;

import com.peisia.c.util.Cw;

public class Disp {
	String x = "x";
	
	final static String DOT = "◎";
	final static int DOT_COUNT = 10;
	public static void line() {
		for(int i=0; i<DOT_COUNT; i++) {
			Cw.w(DOT);
		}
		Cw.wn();
	}
	public static void title() {
		line();
		Cw.w(" 조마루 감자탕 ");
		Cw.wn();
		line();
	}
}
