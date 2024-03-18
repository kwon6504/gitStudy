package com.lowlist.Dto;

public class DtoMember {
	
	public String no;
	public String id;
	public String pw;
	public int loginno = 0;
	
	public DtoMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public DtoMember(int loginno,String id) {
		this.loginno = loginno;
		this.id = id;
	}
	public DtoMember(int loginno) {
		this.loginno = loginno;
	}
}
