package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.BoardDto;

public interface BoardService {
	//글 목록
	public ArrayList<BoardDto> getList();
	//글쓰기
	public void write(BoardDto dto);
}
