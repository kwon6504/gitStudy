package com.peisia.domain;

import lombok.Data;

@Data
public class GuestVO {
	private Long bno;
	private String btext;
	private String searchword;
	private int limitIndex;
	private int currentPage;
}