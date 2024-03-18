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
	public ArrayList<BoardDto> getList(){
		log.info("되니?");
		return mapper.getList();
	}
	
	@Override //글 쓰기
	public void write(BoardDto dto){
		mapper.write(dto);
	}
}
