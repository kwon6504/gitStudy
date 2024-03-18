package q23_v9_kiosk;

public class Drink extends MenuInfo {

	// 아래 함수를 선언하고 다른곳으로 불러오려면 java 파일명.n; 으로 선언하면 불러올수있음
	public static void drinkinfo() {
		System.out.println("-------드링크 메뉴입니다-------");
		dr1.info();
		dr2.info();
		dr3.info();
		dr4.info();
		System.out.println("메인메뉴로 돌아가기[e] / 메뉴 다시보기 [r]");
		System.out.println("---------------------------");
		drinkstrat: while (true) {
			System.out.println("드링크를 선택해주세요!");
			System.out.println("메인메뉴로 돌아가기[e] 메뉴 다시보기 [r]");
			System.out.println("장바구니 비우기[c] 장바구니 확인[v]");
			cmd = sc.next();
			switch (cmd) {
			case "1":
				dr1.addsetdrink();
				DrinkSize.drinksize();
				drink.add(dr1);
				dr1.info();
				break;
			case "2":
				dr2.addsetdrink();
				DrinkSize.drinksize();
				drink.add(dr2);
				dr2.info();
				break;
			case "3":
				dr3.addsetdrink();
				DrinkSize.drinksize();
				drink.add(dr3);
				dr3.info();
				break;
			case "4":
				dr4.addsetdrink();
				DrinkSize.drinksize();
				drink.add(dr4);
				dr4.info();
				break;
			case "r":
				System.out.println("-------드링크 메뉴입니다-------");
				dr1.info();
				dr2.info();
				dr3.info();
				dr4.info();
				System.out.println("메인메뉴로 돌아가기[e] / 메뉴 다시보기[r]");
				System.out.println("---------------------------");
				break;
			case "e":
				break drinkstrat;
			case "c":
				drink.clear();
				drink_T.clear();
				drinksize.clear();
				dessert.clear();
				break;
			case "v":
				Cash_drink.cashrun();
				break;

			}

		}

	}

}
