package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;
import com.peisia.dto.SearchDto;

public interface GuestMapper {
	public ArrayList<GuestDto> getList(int limitIndex);
//	public ArrayList<SearchDto> searchList(SearchDto dto);
	public ArrayList<GuestDto> searchList(GuestDto dto);
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
	public int listCount();
	public int searchListCount(String word);
}
