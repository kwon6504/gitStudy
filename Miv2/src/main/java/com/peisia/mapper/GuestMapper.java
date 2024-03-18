package com.peisia.mapper;

import java.util.List;

import com.peisia.domain.GuestVO;
import com.peisia.domain.PageingVO;

public interface GuestMapper {
	public List<GuestVO> getList(int limitIndex);
	public List<GuestVO> searchList(GuestVO gvo);
	public int getPageCount(String searchword);
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
}
