package com.peisia.c.test;

public class Item extends GameObj {
	int weight;	//무게
	int life;	//아이템 수명
	Item(String name, int grade, int weight, int life){
//		super(); //부모자식관계에서 자식 함수 아래에 부모 생성자 함수가 무조건 들어간다. 빈함수로
		super(name,grade); //super 은 무조건 제일 먼저 나와야한다.
		// name하고 grade를 보내서 부모함수에게 세팅하게 해준다.
		this.weight = weight;
		this.life = life;
	}
}
