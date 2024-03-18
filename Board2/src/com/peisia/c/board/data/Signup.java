package com.peisia.c.board.data;

public class Signup {
	String id;
	String pw;
	String name;

	public Signup(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
}
