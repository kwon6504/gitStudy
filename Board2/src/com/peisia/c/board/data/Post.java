package com.peisia.c.board.data;

import java.time.LocalDate;

import com.peisia.util.Cw;

public class Post {
	
	Signup Id;
	public static int no = 0;
	public int instanceNo = 0;
	public int originNo = 0;
	public String title;
	public String content;
	public String id;
	public Boolean isComment = false;
	public int hit;
	public String date;
	
	public Post (int no, String title, String content, String id) {
//		no = no + 1;
		instanceNo = no;
		this.title = title;
		this.content = content;
		this.id = id;
		LocalDate now = LocalDate.now();
		date = now.toString();
	}
	public Post (String title, String content, String id, int hit, int originNo) {
		no = no + 1;
		instanceNo = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.hit = hit;
		this.isComment = true;
		this.originNo = originNo;
		LocalDate now = LocalDate.now();
		date = now.toString();
	}
	
	public void infoForList() {
		Cw.w("글번호:"+instanceNo);
		Cw.w(" 글제목:"+title);
		Cw.w(" 작성자:"+id);
		Cw.w(" 조회수:"+hit);
		Cw.wn(" 작성일:"+date);
	}
	public void infoForRead() {
		Cw.w("글제목:"+title);
		Cw.w(" 작성자:"+ id);
		Cw.w(" 조회수:"+hit);
		Cw.wn(" 작성일:"+date);
		Cw.wn("글내용:"+content);
		
	}
}
