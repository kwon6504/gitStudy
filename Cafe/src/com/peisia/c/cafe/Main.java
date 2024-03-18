package com.peisia.c.cafe;

public class Main {
	public static void main(String[] args) {
		Kiosk k = new Kiosk(); //public static이 없이 Kiosk에서 void run()을 만들어서 객체 선언을 해야한다.
		k.run(); // static이 있어야 객체 생성 없이 바로출력이 가능하다.
		
	}
}
