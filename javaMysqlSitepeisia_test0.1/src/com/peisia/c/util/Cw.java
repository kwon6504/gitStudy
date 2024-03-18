package com.peisia.c.util;

public class Cw {
	static private final String DOT = "◈";
	static private final int LINE_LENGTH = 32;
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
		for(int i=0; i<LINE_LENGTH; i=i+1) {
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
