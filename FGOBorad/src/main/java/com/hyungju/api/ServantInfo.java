package com.hyungju.api;

import lombok.Data;

@Data
public class ServantInfo {
	private int id;
	private String name;
	private String className;
	private int rarity;
	private String face;
	public ServantInfo(int id,String name,int rarity,String face,String className) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.rarity = rarity;
		this.face = face;
	}

}
