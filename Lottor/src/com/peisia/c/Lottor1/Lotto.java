package com.peisia.c.Lottor1;

public class Lotto {
	public void run() {
		// int x[]= {1,2}; 배열의 예시
		int p[] = { 1, 2, 3, 4, 5, 6 };
		int r[] = new int[6];
		int b = 0;
		System.out.println("담청번호");

		r[0] = (int) (Math.random() * 45 + 1);

		while (true) {
			r[1] = (int) (Math.random() * 45 + 1);
			if (r[1] != r[0]) {
				break;
			}
		}
		while (true) {
			r[2] = (int) (Math.random() * 45 + 1);
			if (r[2] != r[0] && r[2] != r[1]) {
				break;
			}
		}
		while (true) {
			r[3] = (int) (Math.random() * 45 + 1);
			if (r[3] != r[0] && r[3] != r[1] && r[3] != r[2]) {
				break;
			}
		}
		while (true) {
			r[4] = (int) (Math.random() * 45 + 1);
			if (r[4] != r[0] && r[4] != r[1] && r[4] != r[2] && r[4] != r[3]) {
				break;
			}
		}
		while (true) {
			r[5] = (int) (Math.random() * 45 + 1);
			if (r[5] != r[0] && r[5] != r[1] && r[5] != r[2] && r[5] != r[3] && r[5] != r[4]) {
				break;
			}
		}
		while (true) {
			b = (int) (Math.random() * 45 + 1);
			if (b != r[0] && b != r[1] && b != r[2] && b != r[3] && b != r[4] && b != r[5]) {
				break;
			}
		}

		System.out.print(r[0] + " ");
		System.out.print(r[1] + " ");
		System.out.print(r[2] + " ");
		System.out.print(r[3] + " ");
		System.out.print(r[4] + " ");
		System.out.println(r[5] + " ");
		System.out.println(b + "+보너스 숫자");
		// print는 출력후 엔터 안하는 애(오른쪽으로 쭉 찍힘)
		// println은 출력후 엔터하는 애
		// println에서 ln은 줄바꿈

		int win = 0;
//		if(p[0] == r[0]) { win++; }
//		if(p[0] == r[1]) { win++; }
//		if(p[0] == r[2]) { win++; }
//		if(p[0] == r[3]) { win++; }
//		if(p[0] == r[4]) { win++; }
//		if(p[0] == r[5]) { win++; }
//		if(p[1] == r[0]) { win++; }
//		if(p[1] == r[1]) { win++; }
//		if(p[1] == r[2]) { win++; }
//		if(p[1] == r[3]) { win++; }
//		if(p[1] == r[4]) { win++; }
//		if(p[1] == r[5]) { win++; }
//		if(p[2] == r[0]) { win++; }
//		if(p[2] == r[1]) { win++; }
//		if(p[2] == r[2]) { win++; }
//		if(p[2] == r[3]) { win++; }
//		if(p[2] == r[4]) { win++; }
//		if(p[2] == r[5]) { win++; }
//		if(p[3] == r[0]) { win++; }
//		if(p[3] == r[1]) { win++; }
//		if(p[3] == r[2]) { win++; }
//		if(p[3] == r[3]) { win++; }
//		if(p[3] == r[4]) { win++; }
//		if(p[3] == r[5]) { win++; }
//		if(p[4] == r[0]) { win++; }
//		if(p[4] == r[1]) { win++; }
//		if(p[4] == r[2]) { win++; }
//		if(p[4] == r[3]) { win++; }
//		if(p[4] == r[4]) { win++; }
//		if(p[4] == r[5]) { win++; }
//		if(p[5] == r[0]) { win++; }
//		if(p[5] == r[1]) { win++; }
//		if(p[5] == r[2]) { win++; }
//		if(p[5] == r[3]) { win++; }
//		if(p[5] == r[4]) { win++; }
//		if(p[5] == r[5]) { win++; }

		for (int i = 0; i <= 5; i = i + 1) {
			for (int j = 0; j <= 5; j = j + 1) {
				if (p[i] == r[j]) {
					win = win + 1;
				}
			}
		}
		System.out.println("맞춘갯수:" + win);

		if (win <= 2) {
			System.out.println("꽝 입니다.");
		} else if (win == 3) {
			System.out.println("5등 입니다.");
		} else if (win == 4) {
			System.out.println("4등 입니다.");
		} else if (win == 5) {
			String temp = "3등 입니다.";
			for (int i = 0; i <= 5; i = i + 1) {
				if (b == p[i]) {
					temp = "2등 입니다.";
				}
			}
			System.out.println(temp);
		} else if (win == 6) {
			System.out.println("1등 입니다.");
		}
	}
}
