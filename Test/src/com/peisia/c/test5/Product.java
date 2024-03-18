package com.peisia.c.test5;

import com.peisia.c.util.Cw;

public class Product {
	//1.변수들
	String name;
	int price;
	
	Product(String xx, int yy){
		name = xx;
		price = yy;
	}
	
	//2.함수들
	void info() {
		Cw.wn("상품명:" + name + "가격: "+price);
	}
}
