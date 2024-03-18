package com.peisia.c.test5;

import com.peisia.c.util.Cw;

public class ProcMenuDrink {
	public static void run() {
		for (Product p : KioskObj.products) {
			Cw.wn(p.name + " " + p.price + "원");
		}
		yy: while (true) {
			Cw.wn("[1.커피/2.오렌지주스/x.이전메뉴]");
			KioskObj.cmd = KioskObj.sc.next();
			switch (KioskObj.cmd) {
			case "1":
				ProcMeunOptionHotCold.run();
				break;
			case "2":
				Cw.wn(KioskObj.products.get(1).name + " 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(1)));
				break;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break yy;
			}
		}
	}
}
