package com.peisia.c.test8.Hash;

import java.util.HashMap;

import com.peisia.c.util.Cw;

public class Main {
	public static void main(String[] args) {
		HashMap<String, String> hs = new HashMap<>();
		hs.put("K-1", "개");
		hs.put("K-2", "고양이");
		hs.put("K-2", "야옹이"); // 키로 부르는것 이기때문에 같은 키라면 마지막에 나온것으로 불러온다
		hs.put("K-3", "토끼");
		int n = hs.size();
		System.out.println(n);
		String x = hs.get("K-2");
		Cw.wn(x);
		hs.remove("K-1"); // K-1 제거
		System.out.println(hs.size());
	}
}
