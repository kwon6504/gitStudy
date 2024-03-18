package q23_v9_kiosk;

public class Dessert extends MenuInfo { //상속

	public static void dessertinfo(){
		
		System.out.println("-------디저트 메뉴입니다-------");
		de1.info();
		de2.info();
		de3.info();
		System.out.println("메인메뉴로 돌아가기[e] / 메뉴 다시보기 [r]");
		System.out.println("장바구니 비우기[c] 디저트 장바구니 확인[v]");
		System.out.println("---------------------------");
	dessertstrat:
	while(true) {
			System.out.println("디저트를 선택해주세요!");
			System.out.println("메인메뉴로 돌아가기[e] 메뉴 다시보기 [r]");
			System.out.println("장바구니 비우기[c] 디저트 장바구니 확인[v]");
			cmd = sc.next();
		switch(cmd) {
			case "1":
				de1.addsetdrink();
				dessert.add(de1);
				break;
			case "2":
				de2.addsetdrink();
				dessert.add(de2);
				break;
			case "3":
				de3.addsetdrink();
				dessert.add(de3);
				break;
			case "r":
				System.out.println("-------디저트 메뉴입니다-------");
				de1.info();
				de2.info();
				de3.info();
				System.out.println("메인메뉴로 돌아가기[e] / 메뉴 다시보기 [r]");
				System.out.println("장바구니 비우기[c] 디저트 장바구니 확인[v]");
				System.out.println("---------------------------");
				break;
			case "e":
				break dessertstrat;
			case "c":
				drink.clear();
				drink_T.clear();
				drinksize.clear();
				dessert.clear();
				break;
			case "v":
				Cash_dessert.cash_dessertrun();
				break;
			
			}
	
		}
	}
	
}
