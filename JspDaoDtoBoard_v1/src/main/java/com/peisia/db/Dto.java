package com.peisia.db;

public class Dto {
	public String no;
	public String title;      
	public String id;         
	public String datetime;
	public String hit;        
	public String text;       
	public String replyCount;
	public String replyOri;
	//글쓰기
	public Dto(String title, String id, String text) {
		this.title = title;
		this.id = id;
		this.text = text;
	}  
	//alt + shift + s 코드 자동 삽입, 마우스 오른쪽> Source> using Fields
	//db에 추가할 전체 내용
	public Dto(String no, String title, String id, String datetime, String hit, String text, String replyCount,
			String replyOri) {
		this.no = no;
		this.title = title;
		this.id = id;
		this.datetime = datetime;
		this.hit = hit;
		this.text = text;
		this.replyCount = replyCount;
		this.replyOri = replyOri;
	}
//	글수정
	public Dto(String title, String text) {
		this.title = title;
		this.text = text;
	}	
	
}
