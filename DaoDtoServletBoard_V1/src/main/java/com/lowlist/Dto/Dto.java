package com.lowlist.Dto;

public class Dto {
	
	public String no;
	public String title;
	public String id;
	public String datetime;
	public String hit;
	public String commentCount;
	public String commentOri;
	public String del_number;
	public String content;
	public String pw;
	public int loginno = 0;

	public int totalblock = 0;
	public int nowBlockNo = 0;
	public int blockStartNo = 0;
	public int blockEndNo = 0;
	public int prevPage = 0;
	public int nextPage = 0;
	public boolean hasPrev = true;
	public boolean hasNext = true;
	
	
	public Dto(int totalblock, int nowBlockNo, int blockStartNo, int blockEndNo, int prevPage, int nextPage ,boolean hasPrev,boolean hasNext ) {
		this.totalblock = totalblock;
		this.nowBlockNo = nowBlockNo;
		this.blockStartNo = blockStartNo;
		this.blockEndNo = blockEndNo;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.hasPrev = hasPrev;
		this.hasNext = hasNext;
	}
	
	public Dto(String title, String id,String content) {
			this.title = title;
			this.id = id;
			this.content = content;
	}
	
	public Dto(String no, String title,String content, String id, String del_number , String hit,String datetime,String commentCount,
			String commentOri ) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.del_number = del_number;
		this.hit = hit;
		this.datetime = datetime;
		this.commentCount = commentCount;
		this.commentOri = commentOri;
	}
	public Dto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	
}
