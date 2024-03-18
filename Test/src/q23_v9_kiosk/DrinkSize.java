package q23_v9_kiosk;

public class DrinkSize extends MenuInfo {
	
	
	public static void drinksize() {
	System.out.println("드링크 사이즈를 골라주세요!");
	System.out.println("주문취소[x]");
	
	sizestart:
		while(true) { 
			si1.sizeinfo();
			si2.sizeinfo();
			si3.sizeinfo();
			si4.sizeinfo();
			cmd = sc.next();
		switch(cmd) {
			case "1":
				si1.addsetsize();
				drinksize.add(si1);
				System.out.println("----------------");
				break sizestart;
			case "2":
				si2.addsetsize();
				drinksize.add(si2);
				System.out.println("----------------");
				break sizestart;
			case "3":
				si3.addsetsize();
				drinksize.add(si3);
				System.out.println("----------------");
				break sizestart;
			case "4":
				si4.addsetsize();
				drinksize.add(si4);
				System.out.println("----------------");
				break sizestart;
			case "x":
				System.out.println("주문을 취소합니다.");
				break sizestart;
			}
	
		}		
		
	}
}

