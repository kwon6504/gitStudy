package q23_v9_kiosk;

public class Cash_drink extends MenuInfo{

	public static void cashrun() {
		
		for(int i = 0;i<drink.size();i++) {
			drink_T.add(drink.get(i));
			drink_T.add(drinksize.get(i));
			}
		if(!drink_T.isEmpty()) {
		for(int i = 0;i<drink_T.size();i++) {
		Product p = drink_T.get(i);
		p.showbarket();
			}
		} else {
			System.out.println("장바구니가 비어있습니다!");
		}
	}

}