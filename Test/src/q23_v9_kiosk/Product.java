package q23_v9_kiosk;

import java.util.ArrayList;

public class Product {

	String name = "";
	int price;
	String number ="";
	//생성자 함수
	
	public Product(String xx,int yy,String aa){
		name = xx;
		price = yy;
		number = aa;
	}
	
	void info() {
		System.out.println(number + ". 상품명: "+ name + " 가격: " + price +"원");
	}
		
	void sizeinfo() {
		System.out.println(number + ".["+ name +"] 사이즈" +" 추가가격 [" + price +"]원");
	}
	
	void addsetdrink() {
		System.out.println("["+ name +"] 가 선택되었습니다.");
	}
	
	void addsetsize() {
		System.out.println("["+ name +"] 사이즈가 선택되었습니다.");
	}

	void addsetdessert() {
		System.out.println("["+ name +"] 가 선택되었습니다.");
	}
	
	void showbarket() {
		System.out.println("["+ name +"]["+ price +"]");
	}
	
	void cashresult() {
		System.out.println("총 계산하실 금액은 ["+ price +"]원 입니다." );
	}
	
	
}
