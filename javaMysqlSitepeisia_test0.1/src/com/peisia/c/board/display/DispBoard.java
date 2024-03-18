package com.peisia.c.board.display;

import com.peisia.c.util.Cw;

public class DispBoard {
	static public String TITLE = "게시판"; // 거래 게시판에서도 활용
	static private String VERSION = "0.1";
	static private String FEAT = "kwon";
	public static void title() {
		Cw.line();
		Cw.dot();
		Cw.space(20);
		Cw.w(TITLE);
		Cw.w(VERSION);
		Cw.w(FEAT);
		Cw.space(20);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
	
	public static void menuMain() {
		Cw.dot();
		Cw.w("[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [6]검색 [x]게시판 종료");
		Cw.dot();
		Cw.wn();
	}
	
	public static void titleList() {
		Cw.wn("==========================================");
		Cw.wn("================= 글리스트 ==================");
		Cw.wn("==========================================");
		Cw.wn("글번호 글제목 작성자id 작성시간");
	}
	
	public static void replyBar() {
		Cw.wn("================= 댓글 리스트 ==================");
	}
}
