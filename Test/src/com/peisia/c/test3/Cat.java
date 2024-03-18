package com.peisia.c.test3;

import javax.swing.Spring;

public class Cat {
	int age;
	String name;

	
	Cat(int age, String name){
		this.age = age;
		this.name = name;
	}

	void info() {
		System.out.println("고양이의 나이는 "+ this.age + "살 이다.");
	}
}
