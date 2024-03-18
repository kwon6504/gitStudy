package com.peisia.c.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static String r() {
		return sc.next();
	}
	
	public static String r(String comment) {
		Cw.w(comment+":");
		return sc.next();
	}
	
	public static String rl(String comment) {
		Cw.w(comment+":");
		try {
			return reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
