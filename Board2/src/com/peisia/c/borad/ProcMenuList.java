package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuList {
	static public final int per_page = 3;
	static int startIndex = 0; // 현재 페이지의 첫 글 인덱스, 페이지 처음으로 나올때 가장먼저 나올 글번호 계산
	// select문 기준으로 처음글이 0이다. 오름차순인가 내림차순인가로 달라질수 있다.
	// limt 명령문에서는 0부터 시작
	static int currentPage = 1; // 현재 페이지
	static boolean isSearchMode = false;
	static int totalPage = 0; // 총 페이지
	static int count = 0;
	static String cmd;

	static void run() {
		Cw.wn("목록");

		count = Load.getPostCount();
		if (count % per_page > 0) {
			totalPage = count / per_page + 1;
		} else {
			totalPage = count / per_page;
		}
		Cw.wn("총 페이지 수:" + totalPage);
		while (true) {
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]");
			if (cmd.equals("x")) {
				break; // 이전 class 로 유도
			}
			try {
				currentPage = Integer.parseInt(cmd);
				if (currentPage > totalPage || currentPage < 1) {
					// 총 페이지수보다 현재 페이지 적어야하고 그리고 1보다는 커야한다.
					Cw.wn("페이지 범위에 맞는 값을 넣어주세요.");
					continue; // 현재 실행 중인 반복문의 남은 부분을 건너뛰고, 다음 반복을 진행
				}
				startIndex = (currentPage - 1) * per_page;
				String a = "select*from board where b_reply_ori is null and b_del=0 limit " + startIndex + ","
						+ per_page;
				try {
					Cw.wn("전송한sql문:" + a);
					Load.dbexecuteQuery(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException e) {
				Cw.wn("맞는 페이지 번호로 입력하세요.");
			}
		}
	}
}
