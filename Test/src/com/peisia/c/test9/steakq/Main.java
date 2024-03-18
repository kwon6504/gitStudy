package com.peisia.c.test9.steakq;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		//처음에 넣은게 나중에 나오는 구조
		st.push("개");
		st.push("삵");
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
