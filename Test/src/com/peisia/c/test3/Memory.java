package com.peisia.c.test3;

public class Memory {

	public static void main(String[] args) {

		// 자동임포트 ctrl+shift+o(영문자O)
//		ArrayList<Product> xx = new ArrayList<Product>();
//		
//		Product p1 = new Product();
//		
//		xx.add(p1);

		// 자바

		// 메모리. 기억. 저장.

		// 1.스택동네
		int n = 100; // 기본형.원시형.p65.소문자로 시작하는 자료형들.
		long l = 1000l;
		float f = 1.5f;

//		Cat kitty;	//명함

		// 2.힙한동네
//		new Cat();		//객체들. 5장의 참조 자료형들. etc. 위 원시형 외 전부

		Cat kitty = new Cat(15, "키티");
		kitty.age = 10; // 100번지

		Cat yaongi;

		yaongi = kitty;

		System.out.println(kitty.age);

		Cat x = kitty;

		x.age = 15;

		System.out.println(x.age);

		System.out.println(kitty.age); // 함수는 위에서 아래로 내려온다
		
		yaongi.age = 4;
		
		System.out.println(yaongi.age);
		
		Hospital h = new Hospital();
		
		h.hotel(kitty);
	}
}
