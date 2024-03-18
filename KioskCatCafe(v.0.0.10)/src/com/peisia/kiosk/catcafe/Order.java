package com.peisia.kiosk.catcafe;

import com.peisia.kiosk.catcafe.product.Product;

public class Order {
	
	public Product selectedProduct; //클래스 변수 선언 = 빈명함을 만든다.
	//상품선택했을때 기록을 남긴다.
	public int optionHotCold = 0;	//1: hot, 2:cold

	public Order(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}// 기본주문 기록

	public Order(Product selectedProduct, int optionHotCold) {
		this.selectedProduct = selectedProduct;
		this.optionHotCold = optionHotCold;
	} //옵션이 생겼을때
}
