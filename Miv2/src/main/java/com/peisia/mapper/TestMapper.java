package com.peisia.mapper;

import com.peisia.spring.dto.TestDto;

public interface TestMapper {
	
	public TestDto getData1();
	public TestDto getData2();
	public TestDto getData3();
	public TestDto getData4();
	void insertData1(TestDto testData);
	void deleteData1(TestDto testData);
	void deleteData2(TestDto testData);
	void updateData1(TestDto testData);
	void updateCount1(TestDto testData);
	void insertCount1(TestDto testData);
	public TestDto getCount1(int aa);
	
}
