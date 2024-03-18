package com.peisia.kiosk.me;

import com.peisia.kiosk.product.Product;
import com.peisia.c.util.Cw;

public class ProcMenuDrink {
	public static void run() {
		int count = 0;
		for (Product p : KioskObj.products) {
			count++;
			if (count >= 6 && count <= 10) {
				Cw.wn(p.name + " " + p.price + "원");
				
			}
//			if (count == 10) {
//				break;
//			}
		}
		xx: while (true) {
			Cw.wn("[1.소주/2.맥주/3.막걸리/4.청하/5.음료수/x.이전메뉴로]");
			KioskObj.cmd = KioskObj.sc.next();
			switch (KioskObj.cmd) {
			case "1":
				Cw.wn(KioskObj.products.get(5).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(5)));
				break;
			case "2":
				Cw.wn(KioskObj.products.get(6).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(6)));
				break;
			case "3":
				Cw.wn(KioskObj.products.get(7).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(7)));
				break;
			case "4":
				Cw.wn(KioskObj.products.get(8).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(8)));
				break;
			case "5":
				Cw.wn(KioskObj.products.get(9).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(9)));
				break;
			case "x":
				Cw.wn("이전메뉴이동");
				break xx;
			}
		}
	}
}
