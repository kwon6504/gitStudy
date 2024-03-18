package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.service.HomeworkService;
import com.peisia.spring.dto.HomeworkDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/homework*")
//@AllArgsConstructor
@Controller

public class HomeworkController {
	
	@Autowired
	private HomeworkService service;
	
	@GetMapping("/selectVisitCount")
	public void selectVisitCount(Model model) {
		log.info("=================컨트롤러에서 조회수카운트 실행중");
		service.updateVisitCount();
		service.selectVisitCount();
		HomeworkDto what = service.selectVisitCount();
		int result = what.getCount();
		model.addAttribute("count",result);
		
		}
}
