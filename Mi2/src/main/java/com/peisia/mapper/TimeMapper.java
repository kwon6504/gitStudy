package com.peisia.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
//	@Select("SELECT sysdate From dual")
	@Select("SELECT now() From dual")
	//dual 가상의 테이블
	public String getTime();
	
	public String getTime2();
}