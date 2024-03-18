package com.peisia.dto;

import lombok.Data;

@Data //lombok.Data를 불러와서 자동으로 세터 겟터 자동 생성
public class BoardDto {
	private Long no;
	private String title;
	private String id;
	private String text;
}
