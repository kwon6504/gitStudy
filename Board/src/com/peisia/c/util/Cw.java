package com.peisia.c.util;

public class Cw {
	private static final String DOT = "◈";
	private static final int DOT_COUNT = 20;
	public static void w(String s) {
		System.out.print(s);
	}
	
	public static void wn(String s) {
		System.out.println(s);
	}
	
	public static void wn() {
		System.out.println();
	}
	
	public static void line() {
		for(int i=0; i<DOT_COUNT; i++) {
			w(DOT);
		}
		wn();
	}
	public static void dot() {
		w(DOT);
	}
	public static void space(int c) {
		for(int i=0; i<c; i++) {
			w(" ");
		}
	}
}
