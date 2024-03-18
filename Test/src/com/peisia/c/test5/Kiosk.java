package com.peisia.c.test5;

import com.peisia.c.util.Cw;

public class Kiosk {
	void run() {
		KioskObj.productLoad(); //상품로드 함수
		Disp.title();
		xx:while(true) {
			Cw.wn("입력 [1.음료선택/2.디저트선택/e.프로그램종료]:");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				ProcMenuDrink.run();
				break;
			case "2":
				ProcMenuDessert.run();
				break;
			case "e":
				Cw.wn("장바구니에 담긴 상품 갯수:" + KioskObj.basket.size());
				int sum = 0;
				for(Order o:KioskObj.basket) {
					sum = sum + o.selectedProduct.price;
				}
				Cw.wn("계산하실 금액은 :" +sum+"원 입니다.");
				
				Cw.wn("==============");
				for(Order o:KioskObj.basket) { //모든 주문한 목록 나오는 for문
					Cw.wn(o.selectedProduct.name);
				}
				Cw.wn("==============");
				Cw.wn("프로그램종료");
				break xx;
			}
		}
	}
}
