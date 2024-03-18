package com.peisia.c.cafe;

import java.util.ArrayList;
import java.util.Scanner;

import com.peisia.c.product.Dessert;
import com.peisia.c.product.Drink;
import com.peisia.c.product.Product;

public class KioskObj {
	public static ArrayList<Product>products = new ArrayList<>();
	public static ArrayList<Order>basket = new ArrayList<>(); //new Arraylisd<>();는 비어있는 상자를 만든다.(초기화하여)
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	
	public static void productload() {
		products.add(new Drink("아메리카노",2000));
		products.add(new Drink("카페라때",3000));
		products.add(new Drink("바나나주스",3000));
		
		products.add(new Dessert("생크림조각케이크",5000));
		products.add(new Dessert("초코조각케이크",5000));
		products.add(new Dessert("쿠키",2000));
	}
}
