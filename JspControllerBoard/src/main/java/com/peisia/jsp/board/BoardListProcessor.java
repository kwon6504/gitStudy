package com.peisia.jsp.board;

import java.util.ArrayList;

import com.peisia.jsp.board.dao.DaoBoard;
import com.peisia.jsp.board.dto.Dto;

public class BoardListProcessor {
	private DaoBoard dao;
	public String category;
	public ArrayList<Dto> posts;
	public int totalPage = 0;
	public int currentPage = 0;
	public String word;

	int totalBlock = 0; // 블럭 총 갯수
	int currentBlockNo = 0; // 현재 블록 번호
	int blockStartNo = 0; // 블록 첫 페이지 번호
	int blockEndNo = 0; // 블록 끝 페이지 번호

	int prevPage = 0; // 이전 블록 페이지
	int nextPage = 0; // 다음 블록 페이지

	boolean hasPrev = true; // 이전 블록 가기 가능한지
	boolean hasNext = true; // 다음 블록 가기 가능환지

	public BoardListProcessor(DaoBoard dao, String category, String currentPage, String word) {
		this.dao = dao;
		this.category = category;
		this.currentPage = Integer.parseInt(currentPage);
		this.word = word;
		if(word == null) {
			this.totalPage = getPageCount();
			getList();
		} else {
			this.totalPage = getPageCount(word);
			getList(word);
		}
		
		totalBlock = (int)Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);
		currentBlockNo = (int)Math.ceil((double)this.currentPage / Board.PAGE_LINK_AMOUNT);
		blockStartNo = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT + 1;
		blockEndNo = currentBlockNo * Board.PAGE_LINK_AMOUNT;
		if(blockEndNo > totalPage) {
			blockEndNo = totalPage;
		}
		
		if(currentBlockNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
			prevPage = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT;
		}
		
		if(currentBlockNo < totalBlock) {
			hasNext = true;
			nextPage = currentBlockNo * Board.PAGE_LINK_AMOUNT + 1;
		} else {
			hasNext = false;
		}
	}
	
	//글리스트
	public void getList() {
		int startIndex = (currentPage - 1) * Board.LIST_AMOUNT;
		posts = dao.selectList(category,startIndex);
	}
	
	// 검색한 글리스트
	public void getList(String word) {
		int startIndex = (currentPage - 1) * Board.LIST_AMOUNT;
		posts = dao.selectList(category, startIndex, word);
	}
	
	//총 페이지 수 구하기
	public int getPageCount() {
		int totalPageCount = 0;
		int count = dao.selectPostCount(category);
		if(count / Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	
	//검색 총 페이지 구하기
	public int getPageCount(String word) {
		int totalPageCount = 0;
		int count = dao.selectSearchPostCount(category, word);
		if(count / Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	
	//글 리스트 객체 얻는 함수 //
	public ArrayList<Dto> getPost() {
		return posts;
	}
	
	//
	public String getHtmlPageList() {
		String html=""; //글 목록 아래 있는 페이지 번호
		if(hasPrev) {
			if(word == null) {
				html = html + String.format("<a href='/board/list?category=%s&page=%d'>이전블록</a>", category, prevPage);
			} else {
				html = html + String.format("<a href='/board/list?category=%s&page=%d&word=%s'>이전블록</a>", category, prevPage, word);
			}
		}
		
		for(int i = blockStartNo; i<=blockEndNo; i++) {
			if(word == null) {
				html = html + String.format("<a href='/board/list?category=%s&page=%d'>%d</a>&nbsp;&nbsp;", category,i,i);
			} else {
				html = html + String.format("<a href='/board/list?category=&s&page=%d&word=%s'>%d</a>&nbsp;&nbsp;", category,i,word,i);
			}
		}
		
		if(hasNext) {
			if(word == null) {
				html = html + String.format("<a href='/board/list?category=%s&page=%d'>다음블록</a>",category,nextPage);
			} else {
				html = html + String.format("<a href='/board/list?category=%s&page=%d&word=%s>다음블록</a>'", category, nextPage, word);
			}
		}
		return html;
	}
}
