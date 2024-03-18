package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void getList(Model model) {
		log.info("==========");
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/write") //글 쓰기 이며 글 작성한것을 보내는 post
	public String write(BoardDto dto) {
		service.write(dto);
		return "redirect:/board/getList";
	}
	
	@GetMapping("/write") //글 쓰기 화면으로 이동시켜주는 get
	public void write() {
	}
}
