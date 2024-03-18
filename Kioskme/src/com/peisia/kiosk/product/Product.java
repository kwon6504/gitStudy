package com.peisia.kiosk.product;

import com.peisia.c.util.Cw;

public class Product {
	public String name;
	public int price;
	
	public Product(String xx,int yy) {
		this.name = xx;
		this.price = yy;
	}
	
	void info() {
		Cw.wn("상품명: "+name+" 가격: "+price);
	}
}
