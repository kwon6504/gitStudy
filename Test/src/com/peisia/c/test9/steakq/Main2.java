package com.peisia.c.test9.steakq;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>(); //객체 생성
		//처음에 넣은게 처음에 나오는 구조
		q.offer("개");
		q.offer("삵");
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}
