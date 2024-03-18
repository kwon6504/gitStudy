package com.peisia.c.cafe;

import com.peisia.util.Cw;

public class Kiosk {
	void run() { //public static 이 있다면 main에서 함수선언없이 함수를 불러올수 있다.
		Disp.title();
		KioskObj.productload();
		loop_a:while(true) {
			Cw.wn("[1.음료수/2.디저트/e.결제]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
			case "2":
			case "e":
				
			}
		}
	}
}
