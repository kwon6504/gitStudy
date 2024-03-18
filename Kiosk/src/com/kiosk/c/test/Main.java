package com.kiosk.c.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("참맛감자탕");
		Kiosk m1 = new Kiosk("감자탕(소)", 18000);
		Kiosk m2 = new Kiosk("감자탕(중)", 26000);
		Kiosk m3 = new Kiosk("감자탕(대)", 35000);
		Kiosk m4 = new Kiosk(5000, "소주");
		Kiosk m5 = new Kiosk(5000, "맥주");
		Kiosk m6 = new Kiosk("뼈추가", 8000);
		Kiosk m7 = new Kiosk("볶음밥", 2000);
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a: while (true) {
			System.out.println("메뉴");
			System.out.println("[1.메인/2.주류/3.추가메뉴/e.종료]");
			cmd = sc.next(); // 여기서 멈춰서 대기하는 함수
			switch (cmd) {
			case "1":
				System.out.println("메인");
				m1.info();
				m2.info();
				m3.info();
				loop_b: while (true) {
					System.out.println("[1.감자탕(소)/2.감자탕(중)/3.감자탕(대)/x.이전화면]");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						System.out.println("감자탕(소)이 선택되었습니다.");
						break;

					case "2":
						System.out.println("감자탕(중)이 선택되었습니다.");
						break;

					case "3":
						System.out.println("감자탕(대)이 선택되었습니다.");
						break;

					case "x":
						break loop_b;
					}
				}
				break;
			case "2":
				System.out.println("주류");
				m4.info();
				m5.info();
				loop_c: while (true) {
					System.out.println("[1.소주/2.맥주/x.이전화면]");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						System.out.println("소주가 선택되었습니다.");
						break;
					case "2":
						System.out.println("맥주가 선택되었습니다.");
						break;
					case "x":
						break loop_c;
					}
				}
				break;
			case "3":
				System.out.println("추가메뉴");
				m6.info();
				m7.info();
				loop_d: while (true) {
					System.out.println("[1.뼈추가/2.볶음밥/x.이전메뉴]");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						System.out.println("뼈추가 선택");
						break;
					case "2":
						System.out.println("볶음밥 선택");
						break;
					case "x":
						break loop_d;
					}
				}
				break;
			case "e":
				break loop_a;
			}
		}
		System.out.println("종료되었습니다.");
	}
}
