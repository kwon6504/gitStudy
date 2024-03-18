package workspace;

import java.util.Scanner;

public class RpcTset {
	public static void main(String[] RGA) {
		System.out.println("가위바위보 중 한개 입력하시오.");
		Scanner sc = new Scanner(System.in);
		String userRpc = sc.next();
		System.out.println(" 낸것은 " + userRpc);
		
		int r = (int) (Math.random()*3+1);
		
		String comRpc = "";
		if(r == 1) {
			comRpc = "가위";
		}
		if(r == 2) {
			comRpc = "바위";
		}
		if(r == 3) {
			comRpc = "보";
		}
		
		System.out.println("컴퓨터가 " + comRpc + " 를 냈습니다.");
		
		String result = "";
		
		if(userRpc.equals("가위")) {
			if(comRpc.equals("가위")) {
				result = "비김";
			}
			if(comRpc.equals("바위")) {
				result = "짐";
			}
			if(comRpc.equals("보")) {
				result = "이김";
			}
		}
		if(userRpc.equals("바위")) {
			if(comRpc.equals("가위")) {
				result = "이김";
			}
			if(comRpc.equals("바위")) {
				result = "비김";
			}
			if(comRpc.equals("보")) {
				result = "짐";
			}
		}
		if(userRpc.equals("보")) {
			if(comRpc.equals("가위")) {
				result = "짐";
			}
			if(comRpc.equals("바위")) {
				result = "이김";
			}
			if(comRpc.equals("보")) {
				result = "비김";
			}
		}
		
		System.out.println("결과: "+result);
	}
}
