package com.peisia.service;

import java.util.List;

import com.peisia.domain.GuestVO;
import com.peisia.domain.PageingVO;

public interface GuestService {
	public List<GuestVO> searchList(int currentPage,String searchword);
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
	public PageingVO pageingList(int currentPage,String searchword);
	public int getPageCount(String searchword);
}
