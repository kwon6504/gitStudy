package com.peisia.c.test;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		//배열
		ArrayList<String> aa = new ArrayList<>(); 
		//뒤쪽 <>안에는 생략가능 현재는 String이기 때문에 문자열만가능
		aa.add("개");//[0]
		aa.add("개");//[1]
		aa.add("개");//[2]
		aa.add("고양이");//[3]
		
		System.out.println(aa.get(3));
		//get은 가져오는것
		
		int size = aa.size(); //배열의 갯수
		for(int i=0; i<size; i++) {
			System.out.println(aa.get(i));
		}
		
		if(aa.contains("고양이")) {
			System.out.println("고양이 있네");
		}
		
		aa.remove(0); //remove 제거하는 함수
		aa.remove(0);
		System.out.println(aa.get(1));
	}
}

