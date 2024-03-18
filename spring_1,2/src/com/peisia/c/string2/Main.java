package com.peisia.c.string2;

public class Main {

	public static void main(String[] args) {
		p193();
		p199();
	}
	
	public static void p193() {
		String cat = "고양이"; //이미 있는 배열이기때문에 새로 만들지 않고 이미 있는 주소지를 넣는다.
		String cat2 = "고양이"; //같은주소지를 받아서 같다
		String cat3 = new String("고양이");
		String cat4 = new String("고양이");// 둘은 서로 새로운집이 생성되기때문에 다르다.
		// System.identityHashCode(cat) << 주소 값 출력함.
		System.out.println(System.identityHashCode(cat));
		System.out.println(System.identityHashCode(cat2));
		System.out.println(System.identityHashCode(cat3));
		System.out.println(System.identityHashCode(cat4));			
	}
	public static void p199() {
		//책.199 예제 참고
//		String s = "abc";
////	Cw.wn(cat.length());
	
//	Cw.wn(s.charAt(1));	// char > int
//	System.out.println(1);
//	System.out.println(s.charAt(1));
	
	char c = 'c';
//	System.out.println(c);
	System.out.println((int)c);
	
	String cat = "고양이";
	System.out.println(String.format("%10s", cat));
	}
}

