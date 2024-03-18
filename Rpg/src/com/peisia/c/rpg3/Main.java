package com.peisia.c.rpg3;

public class Main {

	public static void main(String[] args) {
		Character elf = new Character();
		elf.name = "레골라스"; //상속 아버지(GameObj)가 가지고 있는 변수
		elf.hp = 1;
		elf.info();
		
		Item book = new Item();
		book.weight = 100;
		book.name = "보물상자"; //상속 아버지(GameObj)가 가지고 있는 변수
		book.info();
		
		Sword shortSword = new Sword();
		shortSword.name = "단검"; //상속 할아버지(GameObj)가 가지고 있는 변수
		shortSword.attack = 100; 
		shortSword.weight = 10; // 상속 아버지(Item)가 가지고 있는 변수
		shortSword.info();
	}
}


