package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.domain.GuestVO;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
		
	private GuestService service;
	
//	@GetMapping("/getList")
//	public void getList(@Param("gvo")GuestVO gvo, Model model) {
//		gvo.setNowpage(1);
//		model.addAttribute("list",service.getList(gvo));
//	}
	
	@GetMapping("/getList")
	public void getList(
		@RequestParam(value="currentPage", defaultValue="1") int currentPage,
		@RequestParam(value="searchword", defaultValue="") String searchword,Model model) {
			System.out.println("햇갈리지마아아아아아ㅏ아아"+searchword);
			model.addAttribute("list",service.searchList(currentPage, searchword));
			model.addAttribute("pageing",service.pageingList(currentPage,searchword));
	}
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		service.del(bno);
		return "redirect:/Guest/getList?currentPage=1";	// 책 p.245 참고
	}
	
	@PostMapping("/write")
	public String write(GuestVO gvo) {
		service.write(gvo);
		return "redirect:/Guest/getList?currentPage=1";	// 책 p.245 참고
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
		
	}
	@PostMapping("/modify")
	public String modify(GuestVO gvo) {
		service.modify(gvo);
		return "redirect:/Guest/getList?currentPage=1";
	}
	
	
}