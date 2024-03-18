package com.peisia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.mapper.TestMapper;
import com.peisia.spring.dto.TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class TestServiceImpl implements TestService{

	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;	
	
	@Override
	public String getOne() {
		log.info("test===========");
		TestDto tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}

	@Override
	public String getTwo() {
		log.info("test===========");
		TestDto tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
	
	
	@Override
	public TestDto selectCount(int no) {
		log.info("셀렉트 카운트 잘 작동되는지 확인");
		TestDto aa = mapper.getCount1(no);
		log.info(aa);
		return aa;
	}
	
	@Override
	public TestDto insertCount(int no,int count) {
		log.info("인서트 카운트 잘 작동되는지 확인");
		TestDto aa = new TestDto(no,count);
		mapper.insertCount1(aa);
		return aa;
	}
	
	@Override
	public int updateCount(int no,int count) {
		log.info("업데이트 카운트 잘 작동되는지 확인");
		TestDto aa = new TestDto(no,count);
		mapper.updateCount1(aa);
		return aa.getCount();
	}
	
	
}