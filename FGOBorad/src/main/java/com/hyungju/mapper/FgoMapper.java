package com.hyungju.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.hyungju.api.ServantInfo;

@Repository
//@Repository 데이터베이스 사용하려면 필요한 함수
public interface FgoMapper {
	public void SaveServantData(ServantInfo info);
	public int DataCheck(int id);
	public ArrayList<ServantInfo> getData(String className);
}
