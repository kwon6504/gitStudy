package com.peisia.mapper;

import com.peisia.spring.dto.TestDto;

public interface TestMapper {
	public TestDto getData1();
	public TestDto getData2();
	public TestDto getData3();
	public TestDto getData4();
	
	//문제1 업데이트
	public void updateVisitantCount();
	
	//문제2 인서트
	public void insertDoodle();	
	
	//문제3 딜리트
	public void delTest();

}