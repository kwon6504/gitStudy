package com.peisia.c.test;

public class Character extends GameObj {
	
	// String name;
	int hp;
	
	public Character(String name,int grade,int hp) {
		super(name,grade);	//super 함수는 무조건 맨 처음에 와야함. 룰임. 
		// super: 부모의 생성자
		this.hp = hp;
	}

}
