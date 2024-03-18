package q23_v9_kiosk;

public class LastOrderM extends MenuInfo {
	//마지막 계산후 담아뒀던 장바구니 표기
	public static void LastOrderrun() {
		
		int countCake = 0;
		int countMacaron = 0;
		int countSandwich = 0;
		int countHotCoffee = 0;
		int countIceCoffee = 0;
		int countIchigo = 0;
		int countMomo = 0;
		
		if(!dessert.isEmpty()) {
		for (int i = 0; i < dessert.size(); i++) {
			Product LastOrderDessert = dessert.get(i);
			
			LastOrder.add(LastOrderDessert);
		
			if (LastOrderDessert.name.equals("케이크")) {
				countCake++;
            }
            if (LastOrderDessert.name.equals("마카롱")) {
            	countMacaron++;
            }
            if (LastOrderDessert.name.equals("샌드위치")) {
            	countSandwich++;
            }
		}
		}
		else {System.out.println("디저트 없음.");
		}
		
		if(!drink.isEmpty()) {
		for (int i = 0; i<drink.size(); i++) {
			Product LastOrderDrink = drink.get(i);
            Product LastOrderDrinkSizeItem = drinksize.get(i);

            LastOrder.add(LastOrderDrink);
            LastOrder.add(LastOrderDrinkSizeItem);

            if (LastOrderDrink.name.equals("뜨거운커피")) {
                countHotCoffee++;
            }
            if (LastOrderDrink.name.equals("아이스아메리카노")) {
            	countIceCoffee++;
            }
            if (LastOrderDrink.name.equals("딸기스무디")) {
            	countIchigo++;
            }
            if (LastOrderDrink.name.equals("복숭아스무디")) {
            	countMomo++;
            }
		}
		}
		else{System.out.println("드링크 없음.");
		}
		
		if(!LastOrder.isEmpty()) {
		for(int i = 0; i < LastOrder.size(); i++) {
			Product b = LastOrder.get(i);
			b.showbarket();
		}
		System.out.println("============================");
        System.out.println("뜨거운커피:[" + countHotCoffee+"]");
        System.out.println("아이스아메리카노:[" + countIceCoffee+"]");
        System.out.println("딸기스무디:[" + countIchigo+"]");
        System.out.println("복숭아스무디:[" + countMomo+"]");
        System.out.println("============================");
        System.out.println("케이크:[" + countCake+"]");
        System.out.println("마카롱:[" + countMacaron+"]");
        System.out.println("샌드위치:[" + countSandwich+"]");
        System.out.println("============================");
		}
		else {System.out.println("주문하지않았습니다.");
		}
	}
}
