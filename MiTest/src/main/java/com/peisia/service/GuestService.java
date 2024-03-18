package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;
import com.peisia.dto.SearchDto;
import com.peisia.paging.pagingProcessor;


public interface GuestService {
	public ArrayList<GuestDto> getList(int currentPage);					
//	public ArrayList<SearchDto> searchList(int currentPage,String word);					
	public ArrayList<GuestDto> searchList(int currentPage,String word);					
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
	public pagingProcessor pageBlock(int currentPage,String word);
	public int listCount();
	
}
