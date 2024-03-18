package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.BoardDto;
import com.peisia.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")	
@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/getList") //글 목록
	public String getList(@RequestParam("currentPage") int currentPage, Model model) {
		log.info("리스트==========");
		model.addAttribute("list",service.getList(currentPage));
		return "/Board/getList";
	}
	
	@PostMapping("/write") //글 쓰기 이며 글 작성한것을 보내는 post
	public String write(BoardDto dto) {
		service.write(dto);
		return "redirect:/board/getList";
	}
	
	@GetMapping("/write") //글 쓰기 화면으로 이동시켜주는 get
	public String write() {
		return "/Board/write";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("no") Long no, Model model) {
		log.info("글읽기=========="+no);
		model.addAttribute("read",service.read(no));
		return "/Board/read";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("no") Long no) {
		log.info("글삭제=========="+no);
		service.del(no);
		return "redirect:/board/getList";
	}
	
	@PostMapping("/modify")
	public String modify(BoardDto dto) {
		service.modify(dto);
		return "redirect:/board/getList";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("no") Long no, Model model) {
		log.info("글수정=========="+no);
		model.addAttribute("read",service.read(no));
		return "/Board/modify";
	}
}
