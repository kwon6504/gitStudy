package com.peisia.c.rps1;

import java.util.Scanner; //java.util이라는 패키지에서 class인 Scanner을 가져오는 함수(import)
//사용자입력을 스캔하는 기능을하는 내장 class

public class Main {
	public static void main(String[] args) { // 자바 프로그램 실행기가 이 메인함수 위치를 찾아서 실행시킴
		System.out.println("가위바위보 중 한가지를 입력해주세요.");
		Scanner sc = new Scanner(System.in); // java.util.Scanner는 java안에 이미 내장되었는것을 가져온것이라 ctrl+스페이스바로 가져온다.
		String userRpc = sc.next(); // 입력을 기다리는 상태, string은 예외적으로 new를 사용하지 않는다.
		System.out.println("님이 낸것은" + userRpc); // 입력하면 변화하는 함수

		int r = (int) (Math.random() * 3 + 1); // 1~6 까지 랜덤하게 뽑음
		System.out.println("주사위를 굴려 " + r + "이 나왔습니다.");

		String comRpc = "";
		if (r == 1) {
			comRpc = "가위";
		} else if (r == 2) {
			comRpc = "바위";
		} else if (r == 3) {
			comRpc = "보";
		}

		System.out.println("컴퓨터가 " + comRpc + "냈습니다.");
		// java에서는 if(s == "고양이")로는 문자열 비교 불가능 if(s.equals("고양이") )를 써야한다.
		// 문자열을 비교할때만 equals
		String result = "";

		if (userRpc.equals("가위")) {
			if (comRpc.equals("가위")) {
				result = "비김";
			}
			if (comRpc.equals("바위")) {
				result = "짐";
			}
			if (comRpc.equals("보")) {
				result = "이김";
			}
		}
		if (userRpc.equals("바위")) {
			if (comRpc.equals("가위")) {
				result = "이김";
			}
			if (comRpc.equals("바위")) {
				result = "비김";
			}
			if (comRpc.equals("보")) {
				result = "짐";
			}
		}
		if (userRpc.equals("보")) {
			if (comRpc.equals("가위")) {
				result = "짐";
			}
			if (comRpc.equals("바위")) {
				result = "이김";
			}
			if (comRpc.equals("보")) {
				result = "비김";
			}
		}
		System.out.println("결과:" + result);
	}
}
