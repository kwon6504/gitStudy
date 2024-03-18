package com.peisia.kiosk.catcafe;

import com.peisia.kiosk.catcafe.product.Drink;
import com.peisia.kiosk.catcafe.product.Product;
import com.peisia.util.Cw;

public class ProcMenuDrink {
	
	public static void run() {
		
		for(Product p:KioskObj.products) {	//메뉴출력 v.0.0.11
			//'KioskObj'라는 객체의 'products'라는 목록(리스트) 안에 있는 각각의 'Product'를 하나씩 차례대로 꺼내서 사용하려고 함
			if(p instanceof Drink) {	//메뉴 출력을 이쪽 계열(Drink) 상품만 출력 처리
				//p라는 객체 instanceof에 의해서 p가 Drink라고 검사하는 키워드 맞다면 Drink를 출력한다.
				//조건문으로 확인이 가능하다.
				Cw.wn(p.name+" "+p.price +"원");
			}
		}
		yy:while(true) {
			
			Cw.wn("[1.커피/2.오렌지쥬스/x.이전메뉴로]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				ProcMenuOptionHotCold.run();
				break;
			case "2":
				Cw.wn(KioskObj.products.get(1).name+" 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(1)));	//오더 추가
				break;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break yy;
			}
		}
	}
}