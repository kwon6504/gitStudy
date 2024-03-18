package com.peisia.domain;

import lombok.Data;

@Data
public class PageingVO {
	
	private int getPageCount;
	private int startIndex;
	private int totalpage;
	private int totalblock;
	private int nextBlock;
	private int nowBlockNo;
	private int blockStartNo;
	private int blockEndNo;
	private int loadprevPage;
	private int loadnextPage;
	private boolean hasPrev;
	private boolean hasNext;
	private String searchword;
	
}