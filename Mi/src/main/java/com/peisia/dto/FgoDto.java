package com.peisia.dto;

import lombok.Data;

@Data
public class FgoDto {
	private int id;
	private String face;
	private String name;
	private String className;
	private int rarity;

	public FgoDto(int id, String face, String name, String className, int rarity) {
		this.id = id;
		this.face = face;
		this.name = name;
		this.className = className;
		this.rarity = rarity;
	}
}
