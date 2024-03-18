package com.peisia.kiosk.me;

import com.peisia.kiosk.product.Product;

public class Order {
	public Product selectedProduct;
	public Product option;
	
	public Order(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	public Order(Product selectedProduct,  Product option) {
		this.selectedProduct = selectedProduct;
		this.option = option;
	}
}
