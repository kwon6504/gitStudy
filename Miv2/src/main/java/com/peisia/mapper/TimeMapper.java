package com.peisia.mapper;

import org.apache.ibatis.annotations.Select;

import com.peisia.spring.dto.TestDto;

public interface TimeMapper {
//	@Select("SELECT sysdate From dual")
	@Select("SELECT now() From dual")
	public String getTime();
	public String getTime2();
	
}