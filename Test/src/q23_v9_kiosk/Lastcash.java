package q23_v9_kiosk;

public class Lastcash extends MenuInfo {

	public static void lastcashrun() {
			
		for(Product a : drink) { //:두개를 비교해서 기존문에서 변화를 준다.
			sum_dr = sum_dr + a.price;
		}
		
		for(Product b : drinksize){
			sum_ds = sum_ds + b.price;
		}
		
		for(Product c : dessert) {
			sum_de = sum_de + c.price;
		}
		
		sum_all = sum_dr + sum_ds + sum_de;
		
		}	
	
	}
