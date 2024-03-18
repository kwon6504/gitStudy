package com.peisia.c.product;

import com.peisia.util.Cw;

public class Product {
	public String name;
	public int price;
	
	public Product(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	void info() {
		Cw.wn("상품명: " + this.name + "가격:" + this.price);
	}
}
