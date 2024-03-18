package com.peisia.c.data;

import java.time.LocalDate;

import com.peisia.c.util.Cw;

public class Post {
	public static int no = 0;
	public int instanceNo = 0;
	public String title;
	public String content;
	public String writer;
	public int hit;
	public String date;
	public Post(String title, String content, String writer, int hit) {
		no = no + 1;
		instanceNo = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		LocalDate now = LocalDate.now();
		date = now.toString();
	}
	
	public void infoForList() {
		Cw.w("글번호:"+instanceNo);
		Cw.w("글제목:"+title);
		Cw.w("작성자:"+writer);
		Cw.w("조회수:"+hit);
		Cw.w("작성일:"+date);
	}
	
	public void infoForRead() {
		Cw.w("글제목:"+title);
		Cw.w("작성자:"+writer);
		Cw.w("조회수:"+hit);
		Cw.w("작성일:"+date);
		Cw.w("글내용:"+content);
	}
}