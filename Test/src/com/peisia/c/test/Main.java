package com.peisia.c.test;

import java.util.ArrayList;

//public class Main {
//
//	public static void main(String[] args) {
//		int a = Dice.roll(100);
//		System.out.println(a);
//		System.out.println(Dice.roll(50));
//		System.out.println(Dice.dicenumber);
////		Dice d = new Dice();
////		static이 있다면 new없이 사용가능하다.
//	}
//		
//	
//} // static함수를 사용해서 dice에서 선언한 함수는 main함수에서 new 선언 없이 사용이 가능하다.


public class Main {

	public static void main(String[] args) {
		int x = (int)Math.floor(1.3);
		System.out.println(x);
		ArrayList<Integer> z = new ArrayList<>();
		Integer n = 100;
		int nn = 1;
		
		int xx = n + 1; // integer를 int로 자동 변환 된다. 언박싱이라 표현
		System.out.println();
		Cat cat = new Cat();
		try {
			cat.feed("참치");
			cat.feed("멸치");
		} catch (CatException e) {
			e.printStackTrace(); //이런일이 발생하면 메세지와 오류의 과정의 흐름을 출력해주는 함수.
		}
	}

}

