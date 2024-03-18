package com.peisia.c.rpg2;

public class Javamemory {				
	public static void main(String[] args) {
		Cat kitty = new Cat(10,"키티","식빵굽기");
		//stack에서 kitty라는 명함 생성하면 예를들어 100번지라는 힙에 주소지를 받는다.
		
		Cat yaongi = new Cat();
		yaongi.age = 10;
		//명함을 보고 힙으로 가 주소지에 나와있는 age를 보고 10으로 표현한다.
		
		Cat norangi = new Cat(100,"노랑이");
		
		int sum = norangi.add(1, 2);
		System.out.println(sum);
	}			
}				