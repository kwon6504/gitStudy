package com.peisia.service;

import com.peisia.spring.dto.TestDto;

public interface TestService {
	public String getOne();
	public String getTwo();
	public TestDto insertCount(int no,int count);
	public int updateCount(int no,int count);
	public TestDto selectCount(int no);
}
