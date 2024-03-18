package com.peisia.c.rpg;

public class Main {

	public static void main(String[] args) {
//		Character elf = new Character();
		Character player = new Character("엠피스",100,20,"엘프");
		Monster orc = new Monster("오크전사",50,10);
//		Monster orc = new Monster("오크족장",50,10);
		
		player.info();
		orc.info(); 

	}

}
 // 자바는 class에서 생성자 함수를 개별로 구성해야한다.