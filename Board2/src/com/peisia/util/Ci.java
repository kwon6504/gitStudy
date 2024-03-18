package com.peisia.util;

import java.io.BufferedReader;
import java.io.IOException;
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
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
