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
	
	//db에 등록
	public Dto(String no, String title, String id, String datetime, String hit, String text, String replyCount,
			String replyOri) {
//		super();
		this.no = no;
		this.title = title;
		this.id = id;
		this.datetime = datetime;
		this.hit = hit;
		this.text = text;
		this.replyCount = replyCount;
		this.replyOri = replyOri;
	}
	
	//글쓰기 title, id, text
	public Dto(String title, String id, String text) {
//		super();
		this.title = title;
		this.id = id;
		this.text = text;
	}
	
	//글수정 title, text
	public Dto(String title, String text) {
//		super();
		this.title = title;
		this.text = text;
	}
}
