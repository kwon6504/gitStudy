package com.peisia.c.test7.Singleton;

public class Main {
	public static void main(String[] args) {
		Dog dog = Dog.getInstance();
		
		dog.run();
		
		Dog dog2 = Dog.getInstance(); // Dog의 집을 새로 만드는게 아니고 기존에 있던것을 불러오는 역활만 한다.
	}
}
// 싱글톤은 디자인패턴중 하나이다.
//디자인 패텅은 프로그램을 잘짤려고 선배 개발자들이 만든 이론, 개념이다.
//내장 되어있는 특정 기능이거나 클래스, 함수가아닌 있는걸로 조합해서 만들어낸거