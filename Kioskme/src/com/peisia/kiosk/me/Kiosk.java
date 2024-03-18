package com.peisia.kiosk.me;

import com.peisia.c.util.Cw;
import com.peisia.kiosk.me.KioskObj;
import com.peisia.kiosk.me.Order;
import com.peisia.kiosk.product.Product;

public class Kiosk {
	void run() {
		Disp.title();
		KioskObj.productLoad();
		xx:while(true) {
			int x = 0;
			for (Product p : KioskObj.products) {

				if(x== 5 || x == 10) {Cw.wn();}

				Cw.wn(p.name+" "+p.price + "원");
				x = x+1;
			}
			Cw.wn("[1.메인메뉴/2.주류/3.추가/e.계산]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				ProcMenuFood.run();
				break;
			case "2":
				ProcMenuDrink.run();
				break;
			case "3":
				ProcMenuAddition.run();
				break;
			case "e":
				Cw.wn("장바구니"+KioskObj.basket.size());
				int sum = 0;
				for(Order o:KioskObj.basket) {
					sum = sum + o.selectedProduct.price;
				}
				Cw.wn("총금액은 "+sum+" 입니다.");
				Cw.wn("====================");	////	산거 리스팅	////
				for(Order o:KioskObj.basket) {
					Cw.wn(o.selectedProduct.name);
				}
				Cw.wn("====================");
				Cw.wn("프로그램종료");
				break xx;
			}
		}
	}
}
