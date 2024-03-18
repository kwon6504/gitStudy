package com.peisia.service;

import java.util.List;

import com.peisia.dto.GuestDto;
import com.peisia.dto.PageingVO;

public interface GuestService {
	public List<GuestDto> getList(int currentPage);
	//영민이가 넣음
	public PageingVO pageingList(int currentPage);
	public int getPageCount();
	//영민이가 넣음
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
}
