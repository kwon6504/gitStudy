package com.peisia.service;

import java.util.List;

import com.peisia.dto.Item;
import com.peisia.dto.PageingVO;

public interface TravelService {
	public List<Item> getList(int currentPage);
	public PageingVO pageingList(int currentPage);
	public int getPageCount();
	
}
