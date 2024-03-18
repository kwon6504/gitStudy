package com.peisia.paging;

import com.peisia.mapper.BoardMapper;

public class pagingProcessor {
	private BoardMapper mapper;

	public int totalPage = 0;
	public int currentPage = 0;
	int totalBlock = 0;
	int currentBlockNo = 0;
	int blockStartNo = 0;
	int blockEndNo = 0;
	int prevPage = 0;
	int nextPage = 0;
	String word = "";
	boolean AblePrev = true;
	boolean AbleNext = true;

	public pagingProcessor(int currentPage, BoardMapper mapper, String word) {
		this.mapper = mapper;
		this.currentPage = currentPage;
		this.word = word;
		if (word == null) {
			this.totalPage = getPageCount();
		} else {
			this.totalPage = getSearchCount(word);
		}

		totalBlock = (int) Math.ceil((double) totalPage / 5);
		currentBlockNo = (int) Math.ceil((double) currentPage / 5);
		blockStartNo = (currentBlockNo - 1) * 5 + 1;
		blockEndNo = currentBlockNo * 5;
		if (blockEndNo > totalPage) {
			blockEndNo = totalPage;
		}
		if (currentBlockNo == 1) {
			AblePrev = false;
		} else {
			AblePrev = true;
			int prevPageAdd = (currentBlockNo - 1) * 5;
			prevPage = prevPageAdd;
//			prevPage = (currentBlockNo - 1) * 5; 이친구도 되긴하는데 초기화안시켜서 나중에 문제생길가능성 다분함
		}
		if (currentBlockNo < totalBlock) {
			AbleNext = true;
			int nextPageAdd = currentBlockNo * 5 + 1;
			nextPage = nextPageAdd;
//			nextPage = currentBlockNo * 5 + 1;  이친구도 되긴하는데 초기화안시켜서 나중에 문제생길가능성 다분함
		} else {
			AbleNext = false;
		}
	}

	public int getPageCount() {
		int totalPageCount = 0;
		int count = mapper.listCount();
		if (count % 5 == 0) {
			totalPageCount = count / 5;
		} else {
			totalPageCount = count / 5 + 1;
		}
		return totalPageCount;
	}

	public int getSearchCount(String word) {
		int totalPageCount = 0;
		int count = mapper.searchListCount(word);
		if (count % 5 == 0) {
			totalPageCount = count / 5;
		} else {
			totalPageCount = count / 5 + 1;
		}
		return totalPageCount;
	}

	public String getHtmlPageList() {
		String html = "";
		if (totalPage == getPageCount()) {
			if (AblePrev) {
				html = html + String.format("<a href='/spring/guest/getList?currentPage=%d'>🦀이전블럭가기🦀</a>", prevPage);
			}
			for (int i = blockStartNo; i <= blockEndNo; i++) {
				html = html + String.format("<a href='/spring/guest/getList?&currentPage=%d'>%d</a>&nbsp;&nbsp;", i, i);
			}
			if (AbleNext) {
				html = html + String.format("<a href='/spring/guest/getList?currentPage=%d'>🦀다음블럭가기🦀</a>", nextPage);
			}
		} else {
			if (AblePrev) {
				html = html + String.format("<a href='/spring/guest/search?currentPage=%d&word=%s'>🦀이전블럭가기🦀</a>",
						prevPage, word);
			}
			for (int i = blockStartNo; i <= blockEndNo; i++) {
				html = html + String.format("<a href='/spring/guest/search?&currentPage=%d&word=%s'>%d</a>&nbsp;&nbsp;",
						i, word, i);
			}
			if (AbleNext) {
				html = html + String.format("<a href='/spring/guest/search?currentPage=%d&word=%s'>🦀다음블럭가기🦀</a>",
						nextPage, word);
			}

		}

		return html;
	}
}
