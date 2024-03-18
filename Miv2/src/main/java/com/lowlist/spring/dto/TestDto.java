package com.lowlist.spring.dto;

import lombok.Data;

@Data
public class TestDto {
	private int no;
	private String str_data;
	private int ab;
	private int count;
	private String cd;
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
	
	public TestDto(int no, String str_data) {
		this.no = no;
		this.str_data = str_data;
	}
	
	public TestDto(int no,int count) {
		this.no = no;
		this.count = count;
	}
	
	public TestDto(int no, String str_data, int ab, String cd) {
		this.no = no;
		this.str_data = str_data;
		this.ab = ab;
		this.cd = cd;
	};
}