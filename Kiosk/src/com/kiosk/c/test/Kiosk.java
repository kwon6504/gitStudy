package com.kiosk.c.test;

public class Kiosk {
	String name;
	int price;
	
	Kiosk(int price, String name){
		this.price = price;
		this.name = name;
	}
	
	Kiosk(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	void info() {
		System.out.println(name + "가격: " + price + "원");
	}
}
