package com.peisia.c.test;

public class Cat {
	
	void x(Object xx) { // 모든 클래스를 다 받겠다.
		Son son = new Son("아들", 3);
		Object o;
		o = son;
		String x;
	}
//    public void feed(String food) throws CatException { //
    public void feed(String food) throws CatException { //feed라는 함수를 호출하면은 throws를 출력할수있는 여지를 준다.
        if (!food.equals("참치")) {
            throw new CatException("이 고양이는 참치를 원해요!"); //throw 던지다. 에외를 발생시키는 선언문
        } else {
            System.out.println("고양이가 참치를 먹고 행복해합니다.");
        }
        
//        Object o;
//        equals(o);
    }
}