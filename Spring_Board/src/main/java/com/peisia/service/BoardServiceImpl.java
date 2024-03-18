package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.peisia.dto.BoardDto;
import com.peisia.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = @Autowired) //@Autowired 이것만 적어도 작동한다.
	private BoardMapper mapper;	
	
	@Override //글 목록
	public ArrayList<BoardDto> getList(int currentPage){
		log.info("리스트===========");
		int limitIndex = (currentPage-1)*5;
		return mapper.getList(limitIndex);
	}
	
	@Override //게시글 총 수
	public int listCount() {
		return mapper.listCount();
	}
	
	@Override //검색한 글 목록
	public ArrayList<BoardDto> searchList(int currentPage, String word) {
		log.info("검색 리스트 ============");
		int limitIndex = (currentPage-1)*5;
		BoardDto search = new BoardDto();
		search.setLimitIndex(limitIndex);
		search.setWord(word);
		return mapper.searchList(search);
	}
	
	@Override //글 쓰기
	public void write(BoardDto dto){
		mapper.write(dto);
	}
	
	@Override //글 읽기
	public BoardDto read(Long no) {
		return mapper.read(no);
	}
	
	@Override //글 삭제
	public void del(Long no) {
		mapper.del(no);
	}
	
	@Override //글 수정
	public void modify(BoardDto dto) {
		mapper.modify(dto);
	}
}
