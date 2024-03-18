package com.peisia.c.rpg;

public class Monster {
	String name;
	int hp;
	int attack;
	
	Monster(String name, int hp, int attack){
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		System.out.println("오크마을에서 " + name + "가 엘프의숲으로 들어갔습니다.");
	}
	
	void info() {
		System.out.println("이름:"+this.name+"["+this.hp+"]"
				+" 공격력:"+this.attack); 
	}
}