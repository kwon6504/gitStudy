package com.peisia.spring.dto;

import lombok.Data;

@Data
public class HomeworkDto {
	private String h_text;
	private int h_no;
	private int count;
	private int no;
	public HomeworkDto(String h_text) {
		this.h_text = h_text;
	}
	public HomeworkDto(int h_no,String h_text) {
		this.h_no = h_no;
		this.h_text = h_text;
		
	}
	public HomeworkDto(int no,int count) {
		this.no = no;
		this.count = count;
	}
}
