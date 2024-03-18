package com.peisia.c.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	// 한줄씩 읽어 오는데 ex)게시판에 올린 글을 띄어쓰기가 있어도 출력해준다.
	public static String r() {
		return sc.next();
	}

	public static String r(String comment) {
		Cw.w(comment + ":");
		return sc.next();
	}

	public static String rl(String comment) {
		Cw.w(comment + ":");
		try {
			return reader.readLine();
		} catch (IOException e) {
			// 상수 IOException 공용매서드
			System.out.println("진정한 남자는 오류를 보지 않는다.");
			e.printStackTrace();
			// 흔적들을 출력해주는 함수
			// 업무상 필수적인 에러 표시
			// 오류가 나오면 캐치한다.
			return null;
		}

	}

}
