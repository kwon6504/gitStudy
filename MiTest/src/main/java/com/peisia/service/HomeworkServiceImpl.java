package com.peisia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.mapper.HomeworkMapper;import com.peisia.spring.dto.HomeworkDto;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor

public class HomeworkServiceImpl implements HomeworkService{
	
	@Autowired
	private HomeworkMapper mapper;
	
	@Override
	public void updateVisitCount() {
		mapper.updateVisitCount();
	}
	@Override
	public HomeworkDto selectVisitCount() {
		mapper.selectVisitCount();
		HomeworkDto count = mapper.selectVisitCount();
		return count;
	}
}
