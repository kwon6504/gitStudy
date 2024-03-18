package com.peisia.c.test7.Singleton;

public class Dog {
	
	private static Dog x = new Dog(); //static 변수는 static변수로만 받을 수 있다.
	
	private Dog() {
		System.out.println("개가 태어남");
	}
	
	public static Dog getInstance() { //private로 접근 불가능하게 만들었짐만 getInstance로 불로 올수 있게 만들어준다.
//		x = new Dog();
		return x;
	}
	
	void run() {
		System.out.println("개가 뜀니다.");
	}
}
