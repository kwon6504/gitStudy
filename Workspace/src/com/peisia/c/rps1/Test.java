package com.peisia.c.rps1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("가위바위보중 한개를 제출하시오.");
		Scanner sc = new Scanner(System.in);
		String player = sc.next();
		System.out.println("제출한것은 " + player);
		
		int r = (int)(Math.random()*3+1);
		
		String computer = "";
		if(r == 1) {
			computer = "가위";
		}
		else if(r == 2) {
			computer = "바위";
		}
		else if(r == 3) {
			computer = "보";
		}
		
		System.out.println("AI가 낸것은 " + computer);
		
		String result = "";
		
		if(player.equals("가위")) {
			if(computer.equals("가위")) {
				result = "비김";
			}
			if(computer.equals("바위")) {
				result = "짐";
			}
			if(computer.equals("보")) {
				result = "이김";
			}
		}
		if(player.equals("바위")) {
			if(computer.equals("가위")) {
				result = "이김";
			}
			if(computer.equals("바위")) {
				result = "비김";
			}
			if(computer.equals("보")) {
				result = "짐";
			}
		}
		if(player.equals("보")) {
			if(computer.equals("가위")) {
				result = "이김";
			}
			if(computer.equals("바위")) {
				result = "짐";
			}
			if(computer.equals("보")) {
				result = "비김";
			}
		}
		
		System.out.println("승부는 " + result);
	}
}
