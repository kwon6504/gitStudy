package com.peisia.c.test;

public class CatException extends Exception {					
	// 기본 생성자				
	public CatException() {				
		super("고양이 예외 발생: 이 고양이는 뭔가 잘못됐어요.");			
	}				
					
	// 사용자 지정 메시지를 포함하는 생성자				
	public CatException(String message) {				
		super(message);			
	}				
}					
