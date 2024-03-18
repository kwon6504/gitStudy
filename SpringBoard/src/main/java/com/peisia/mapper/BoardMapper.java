package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.BoardDto;

public interface BoardMapper {
	//글목록
	public ArrayList<BoardDto> getList();
	//글쓰기
	public void write(BoardDto dto);
}
