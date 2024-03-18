package com.peisia.kiosk.me;

import com.peisia.c.util.Cw;
import com.peisia.kiosk.product.Product;

public class ProcMenuAddition {
	public static void run() {
		int count = 0;
		for (Product p : KioskObj.products) {
			count++;
			if(count >= 11 && count <= 13) {
				Cw.wn(p.name + " " + p.price + "원");
			}
		}
		zz:while(true) {
			Cw.wn("[1.뼈추가/2.볶음밥/3.공깃밥/x.이전메뉴]");
			KioskObj.cmd =  KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1" :
				Cw.wn(KioskObj.products.get(10).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(10)));
				break;
			case "2" :
				Cw.wn(KioskObj.products.get(11).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(11)));
				break;
			case "3" :
				Cw.wn(KioskObj.products.get(12).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(12)));
				break;
			case "x":
				Cw.wn("이전 메뉴 가지");
				break zz;
			}
		}
	}
}
