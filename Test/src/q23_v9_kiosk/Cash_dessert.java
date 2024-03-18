package q23_v9_kiosk;

public class Cash_dessert extends MenuInfo {
	
	public static void cash_dessertrun(){
	
		for(int i = 0;i<dessert.size();i++) {
			drdeds_T.add(dessert.get(i));	
		}
		if (!drdeds_T.isEmpty()) {
		    for (int i = 0; i < drdeds_T.size(); i++) {
		        Product q = drdeds_T.get(i);
		        q.showbarket();
		    }
		} else {
		    System.out.println("장바구니가 비어있습니다!");
		}

	}
}
