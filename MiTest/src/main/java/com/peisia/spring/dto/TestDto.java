package com.peisia.spring.dto;

import lombok.Data;


@Data
public class TestDto {
//	private Long no;
//	private String str_data;
//
//	private int noooo;
//	private String data;
	private String h_text;
	//롬복 라이브러리가 아래 게터함수, 세터함수를 자동으로 만들어줌. @Data 라고 붙이면.
	
	//게터, 게터함수, 게터메소드
//	public Long getNo() {
//		return no;
//	}
	
	//세터
//	public void setNo(Long no) {
//		this.no = no;
//	}
	
	//str_data 쪽 게터,세터도 ...

//	public TestDto (int noooo ,String data){
//		this.noooo = noooo;
//		this.data = data;
//	}
	public TestDto (String h_text) {
		this.h_text = h_text;
	}
}



	
