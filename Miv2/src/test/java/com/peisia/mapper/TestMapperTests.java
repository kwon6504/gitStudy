package com.peisia.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peisia.spring.dto.TestDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void testGetList() {
//		TestDto aacc = null;
//		ArrayList<TestDto> asd = new ArrayList<TestDto>();
//		TestDto sData1 = mapper.getData1();
//		TestDto sData2 = mapper.getData2();
//		log.info(sData1);
//		log.info(sData2);
//		String s1 = sData1.getStr_data();
//		String s2 = sData2.getStr_data();
//		int n1 = Integer.parseInt(s1);
//		int n2 = Integer.parseInt(s2);
//		int sum = n1 + n2;
//		log.info("1+2 는 ==============:" + sum);
//		TestDto aab = new TestDto(0, "형주",10000,"바보");
//		asd.add(aab);
//		for(TestDto vvv : asd) {
//			aacc = mapper.getData5(vvv.getNooo());
//		}
//		TestDto aacc = mapper.getData5(0);
//		log.info(aacc);
//		mapper.insertData1(aab);
//		aab = new TestDto(10,"형주바보");
//		mapper.insertData1(aab);
//		aab = new TestDto(100,"형주바보바보");
//		mapper.insertData1(aab);
//		mapper.deleteData1(aab);
//		mapper.deleteData2(aab);
//		mapper.updateData1(aab);
//		log.info(aab);
		
	}
	
}
