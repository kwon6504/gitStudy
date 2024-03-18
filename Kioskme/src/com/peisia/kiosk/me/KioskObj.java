package com.peisia.kiosk.me;

import java.util.ArrayList;
import java.util.Scanner;

import com.peisia.c.util.Cw;
import com.peisia.kiosk.product.Addition;
import com.peisia.kiosk.product.Drink;
import com.peisia.kiosk.product.Food;
import com.peisia.kiosk.product.Option;
import com.peisia.kiosk.product.Product;

public class KioskObj {
	public static ArrayList<Order> basket = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;

	public static void productLoad() {

//		Cw.wn("메인 메뉴");
		products.add(new Food("감자탕(소)", 29000)); // 0
		products.add(new Food("감자탕(중)", 34000)); // 1
		products.add(new Food("감자탕(대)", 39000)); // 2
		products.add(new Food("1인감자탕", 18000)); // 3
		products.add(new Food("뼈다귀해장국", 10000)); // 4

//		Cw.wn("주류");			
		products.add(new Drink("소주", 5000)); // 5
		products.add(new Drink("맥주", 5000)); // 6
		products.add(new Drink("막걸리", 4000)); // 7
		products.add(new Drink("청하", 6000)); // 8
		products.add(new Drink("음료", 2000)); // 9

//		Cw.wn("추가메뉴");			
		products.add(new Addition("뼈추가", 15000)); // 10
		products.add(new Addition("볶음밥", 2000)); // 11
		products.add(new Addition("공깃밥", 1000)); // 12
		
		//사리추가
		products.add(new Option("감자사리", 3000)); //13
		products.add(new Option("우거지사리", 3000)); //14
		products.add(new Option("라면사리", 2000)); //15
		products.add(new Option("우동사리", 2000)); //16
	}
}
