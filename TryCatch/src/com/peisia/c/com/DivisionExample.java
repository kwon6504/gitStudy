package com.peisia.c.com;

import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int numerator = sc.nextInt();
        int denominator = sc.nextInt();

        try {
            // 여기에서 0으로 나누려고 시도합니다.
            int result = numerator / denominator;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            // 만약 0으로 나누려고 하는데 오류가 발생하면 여기서 잡아서 처리합니다.
            System.out.println("0으로 나누려고 하였습니다. 다른 수로 시도해주세요.");
        }
    }
}

