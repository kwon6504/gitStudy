package com.peisia.kiosk.me;

import com.peisia.c.util.Cw;
import com.peisia.kiosk.product.Product;

public class ProcMenuFood {
	public static void run() {
		int count = 0;
		for (Product p : KioskObj.products) {
			Cw.wn(p.name + " " + p.price + "원");
			count++;
			if (count == 5) {
				break;
			}
		}
		yy: while (true) {
			Cw.wn("[1.감자탕(소)/2.감자탕(중)/3.감자탕(대)/4.1인감자탕/5.뼈다귀해장국/x.이전메뉴]");
			KioskObj.cmd = KioskObj.sc.next();
			switch (KioskObj.cmd) {
			case "1":
				Cw.wn(KioskObj.products.get(0).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(0)));
				ProcMenuOption.run();
				break;
			case "2":
				Cw.wn(KioskObj.products.get(1).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(1)));
				ProcMenuOption.run();
				break;
			case "3":
				Cw.wn(KioskObj.products.get(2).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(2)));
				ProcMenuOption.run();
				break;
			case "4":
				Cw.wn(KioskObj.products.get(3).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(3)));
				ProcMenuOption.run();
				break;
			case "5":
				Cw.wn(KioskObj.products.get(4).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(4)));
				ProcMenuOption.run();
				break;
			case "x":
				Cw.wn("이전화면이동");
				break yy;
			}
		}
	}
}
