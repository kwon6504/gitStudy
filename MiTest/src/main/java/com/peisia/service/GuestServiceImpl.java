package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.dto.GuestDto;
import com.peisia.dto.SearchDto;
import com.peisia.mapper.GuestMapper;
import com.peisia.paging.pagingProcessor;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	
	
	@Override
	public ArrayList<GuestDto> getList(int currentPage) {
		log.info("리스트===========");
		
		int limitIndex = (currentPage-1) * 5;
		return mapper.getList(limitIndex);
	}
	@Override
	public ArrayList<GuestDto> searchList(int currentPage,String word) {
		log.info("검색 리스트===========");
		int limitIndex = (currentPage-1) * 5;
//		SearchDto search = new SearchDto(limitIndex,word);
		GuestDto search = new GuestDto();
		search.setLimitIndex(limitIndex);
		search.setWord(word);
		return mapper.searchList(search);
	}
	@Override 
	public pagingProcessor pageBlock(int currentPage,String word) {
		log.info("========페이징블럭 열심히 만드는중========");
		pagingProcessor Paging = new pagingProcessor(currentPage,mapper,word);
		return Paging;
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}
	
	
	@Override
	public GuestDto read(long bno) {
		return mapper.read(bno);
	}
	
	@Override
	public void del(long bno) {
		mapper.del(bno);
	}
	
	@Override
	public void write(GuestDto dto) {
		mapper.write(dto);
	}		
	
	@Override
	public void modify(GuestDto dto) {
		mapper.modify(dto);
	}	
}
