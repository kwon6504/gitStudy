package com.peisia.c.format;

public class Format {
	public static void main(String[] args) {
		int currentHp = 100;
		int maxHp = 200;
		int currentMp = 50;
		int maxMp = 70;

		String s = String.format("[💖%4d/%4d](✨%4d/%4d)", currentHp, maxHp, currentMp, maxMp);
		System.out.println(s);
	}
}

//%s: 문자열
//%d: 정수, 4를 넣어서 4자리 정수라는 뜻
//%f: 부동 소수점 숫자 ,2를 넣으면 소수좀 2자리까지 표현
//%b: 불리언
//%c: 문자
//%n: 개행
//%t: 날짜 및 시간 형식