package com.peisia.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peisia.spring.dto.HomeworkDto;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HomeworkMapperTests {
	
	@Autowired
	private HomeworkMapper mapper;
	
	@Test
	public void testGetList() {
//		ArrayList<HomeworkDto> selectData = mapper.SpringPracticeSelect();
//		log.info(selectData);
		HomeworkDto update1 = new HomeworkDto(1,"왜이리 어렵냐");
//		mapper.SpringPracticeUpdate(update1);
//		log.info("업데이트==============");
		mapper.SpringPracticeDelete(update1);
		log.info("삭제==============");
		
	}

}
