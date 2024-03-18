package com.peisia.kiosk.me;

import com.peisia.c.util.Cw;

public class ProcMenuOption {
	public static void run() {
		loop:while(true) {
			Cw.wn("[1.감자사리/2.우거지사리/3.라면사리/4.우동사리/x.사리없음]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				Cw.wn("감자사리 추가");
				KioskObj.basket.add(new Order(KioskObj.products.get(13)));
				break;
			case "2":
				Cw.wn("우거지 추가");
				KioskObj.basket.add(new Order(KioskObj.products.get(14)));
				break;
			case "3":
				Cw.wn("라면사리");
				KioskObj.basket.add(new Order(KioskObj.products.get(15)));
				break;
			case "4":
				Cw.wn("우동사리");
				KioskObj.basket.add(new Order(KioskObj.products.get(16)));
				break;
			case "x":
				Cw.wn("이전메뉴로이동");
				break loop;
			}
		}
	}
}
