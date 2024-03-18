package com.peisia.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.service.FgoService;
import com.peisia.service.FgoServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/fgo/*")
@AllArgsConstructor
@Controller
public class FgoController {
	
	private FgoService service;
	private FgoServiceImpl serviceImpl;
	
	@GetMapping("/ServantList")
	public void servantList(@RequestParam("className") String className, Model model) throws IOException{
		log.info("======연결중======");
		System.out.println("연결 확인 중");
		model.addAttribute("servant", serviceImpl.getServantData(className));
	}
	
	@GetMapping("/list")
    public String list() {
        return "fgo/list";
    }
}