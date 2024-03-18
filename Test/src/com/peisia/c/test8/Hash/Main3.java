package com.peisia.c.test8.Hash;

import java.util.HashSet;
import java.util.Iterator;

public class Main3 {
	public static void main(String[] args) {
		//HashSet는 바구니에 전부담아서 순서가 없다.
		HashSet<String> hs = new HashSet<>();
		hs.add("개");
		hs.add("고양이");
		hs.add("고양이");
//		hs.remove("고양이");
//		hs.clear(); //HashSet에 모든 요소를 제거
		if(hs.contains("고양이")) { //고양이를 찾는 함수
			System.out.println("이 안에 고양이 있다.");
		}
		
		if(hs.isEmpty()) {
			System.out.println("데이터 없음");
		} else {
			System.out.println("데이터 있음");
		}
		System.out.println(hs.size());
		System.out.println("다 출력(순서 보장 안됨)");
		for(String s:hs) {
			System.out.println(s);
		}
		
		//조금 어렵게 꺼내기
		System.out.println("어렵게 꺼내기");
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) { //hasNext는 꺼낼게 있냐
			String value = it.next();
			System.out.println(value);
		}
	}
}
