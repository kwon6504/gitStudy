package com.peisia.mapper;

import java.util.List;

import com.peisia.dto.GuestDto;

public interface GuestMapper {
	public List<GuestDto> getList(int limitIndex);
	//영민이가 넣음
	public int getPageCount();
	//영민이가 넣음
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
}
