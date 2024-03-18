package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.BoardDto;

public interface BoardMapper {
	// 글 목록
	public ArrayList<BoardDto> getList(int limitIndex);
	
	// 글 검색기능
	public ArrayList<BoardDto> searchList(BoardDto dto);

	// 글쓰기
	public void write(BoardDto dto);

	// 글 읽기
	public BoardDto read(Long no);
	
	// 글 삭제
	public void del(Long no);
	
	// 글 수정
	public void modify(BoardDto dto);
	
	// 게시글 총 수
	public int listCount();
	
	// 검색한 게시글 총 수
	public int searchListCount(String word);
}
