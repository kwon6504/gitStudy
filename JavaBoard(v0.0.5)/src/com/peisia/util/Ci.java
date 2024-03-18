package com.peisia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 입력을 담당하는 클래스. (Scanner 등)
 */
public class Ci {
	static Scanner sc = new Scanner(System.in);
	//BufferedReader는 Scanner
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	//콘솔(키보드)에서 입력을 받기 위한 코드
	//BufferedReader는 한줄씩 읽어나가는 자바 클래스
	static public String r() {
		return sc.next();
		// 단어(또는 문자열)을 읽어오는 메서드
	}
	
	// 주석과 함께 단어(또는 문자열)을 읽어오는 메서드
	static public String r(String comment) {
		Cw.w(comment+":");
		return sc.next();
	}
	
	// 주석과 함께 한 줄 전체를 읽어오는 메서드
	static public String rl(String comment)  { //받아서 처리하는 의무가 생성된다. throws IOException
		Cw.w(comment+":");
//		return reader.readLine();
		try {
			// 한 줄 전체를 읽어와서 반환
			return reader.readLine(); //readLine()은 BufferedReader의 상속관계이다.
		} catch (Exception e) { //IOException는 readLine에서 
			// 예외 발생 시 스택 트레이스 출력 후 null 반환
			e.printStackTrace(); //에러 로그 보여주는 함수
			return null;
		}
	}
}
