package com.peisia.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peisia.spring.dto.TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void testGetList() {
//		TestDto sData1 = mapper.getData1();
//		TestDto sData2 = mapper.getData2();
//		log.info(sData1);
//		log.info(sData2);
//		 TestDto dfa = new TestDto(5,"하이");
//		 mapper.insertData1(dfa);
		 
//		 dfa = new TestDto(10,"add");
//		 mapper.insertData1(dfa);
//		 dfa = new TestDto(5,"헤이");
//		 mapper.insertData1(dfa);
//		 mapper.updateData1(dfa);
		
//		mapper.deleteData2(dfa);
//		log.info(dfa);
//		String s1 = sData1.getStr_data();
//		String s2 = sData2.getStr_data();
//		int n1 = Integer.parseInt(s1);
//		int n2 = Integer.parseInt(s2);
//		int sum = n1 + n2;
//		log.info("1+2 는 ==============:" + sum)
		ArrayList<TestDto> selectData = mapper.SpringPracticeGetData();
		log.info(selectData);
	}
	
}
