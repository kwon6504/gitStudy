package com.peisia.c.test3;

public class Product {
	String name;
	int price;
	
	Product(int price, String name){
		this.name = name;
		this.price = price;
	} //클래스 선언이 이름이 같아도 배열이 다르면? 다른존재로 취급한다.
	// 같은 유형 ex) (string string), (string string) 처럼 구분이 어려우면 불가능하다.
	Product(String name, int price){
		this.name = name;
		this.price = price;
	} //
	
	 void info() {
		System.out.println(name+" 가격:"+price+"원");
	}
}