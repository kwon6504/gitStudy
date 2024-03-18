package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.BoardDto;

public interface BoardService {
	// 글 목록
	public ArrayList<BoardDto> getList(int currentPage);

	// 글 검색기능
	public ArrayList<BoardDto> searchList(int currentPage, String word);

	// 글 쓰기
	public void write(BoardDto dto);

	// 글 읽기
	public BoardDto read(Long no);

	// 글 삭제
	public void del(Long no);

	// 글 수정
	public void modify(BoardDto dto);

	// 게시글 총 수
	public int listCount();
}
