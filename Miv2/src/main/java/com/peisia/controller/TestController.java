package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.service.TestService;
import com.peisia.spring.dto.TestDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
//@AllArgsConstructor
@Controller
public class TestController {
	@Autowired
	private TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		
		log.info("(여기 컨트롤러임) 1 더하기 2는 = " + sum);
		
		model.addAttribute("sum",sum);
	}

	@GetMapping("/updateVisitantCount")
	public void updateVisitantCount(Model model) {	
		
		log.info("updateVisitantCount ==========================================");
		TestDto wto = service.selectCount(0);
		if(0!=wto.getNo()) {
		TestDto one = service.insertCount(0,0);
		log.info("(인서트문)" + one.getNo());
		}
		Integer count = service.updateCount(0,wto.getCount());
		model.addAttribute("Count",count);
	}
	
}
