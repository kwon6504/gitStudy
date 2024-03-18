package com.peisia.dto;

import lombok.Data;

@Data
public class GuestDto {
	private Long bno;
	private String btext;
//	private int limitIndex;
//	private int currentPage;
	private String startNo;
	private String endNo;
}