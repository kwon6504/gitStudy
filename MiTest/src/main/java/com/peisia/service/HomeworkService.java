package com.peisia.service;

import com.peisia.spring.dto.HomeworkDto;

public interface HomeworkService {

	void updateVisitCount();
	HomeworkDto selectVisitCount();

}
