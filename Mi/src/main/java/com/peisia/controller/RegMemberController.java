package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.GuestDto;
import com.peisia.dto.MemberDto;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/regmember/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리
					// 해줌(@Auto.. 처럼)
@Controller
public class RegMemberController {

//	위에 @AllArgsConstructor 이걸 쓰면
//	롬복라이브러리가 아래 코드를 자동으로 삽입해줌

	//
//	public GuestController(GuestService service){
//		this.service = service;
//	}

//	private GuestService service;

	@GetMapping("/regForm")
	public void regForom() {

	}

	@GetMapping("/regProc")
	public void regProc(MemberDto m) {

	}

}