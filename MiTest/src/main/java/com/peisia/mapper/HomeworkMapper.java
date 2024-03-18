package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.spring.dto.HomeworkDto;

public interface HomeworkMapper {
	public ArrayList<HomeworkDto> SpringPracticeSelect();
	void SpringPracticeUpdate(HomeworkDto Dto);
	void SpringPracticeDelete(HomeworkDto Dto);
	void updateVisitCount();
	HomeworkDto selectVisitCount();
}
