package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.KTravelDto;
import com.peisia.service.TravelService;

import lombok.AllArgsConstructor;

//@Log4j
@RequestMapping("/travel/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@Controller
@AllArgsConstructor
public class TravelController {
//	@Setter
	private TravelService service;

//	private GuestService service;

	@RequestMapping("/getList")
	public void getList(@RequestParam("numOfRows") int numOfRows, @RequestParam("pageNo") int pageNo, Model model) {
		String API_KEY = "rR3aTQuk9UBRlPeuThbhKGD81oaxjq2d0L68RpPLHGTsNCGPZW98BtLBG228F8z8HNB82aLxS3Iljaeed5oKkQ==";
		String API_URL = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?numOfRows="+ numOfRows +"&pageNo="+ pageNo +"&MobileOS=ETC&MobileApp=AppTest&arrange=B&_type=json&serviceKey="
				+ API_KEY;
		
		URI uri = null;
		 try {
	           uri = new URI(API_URL);    
	       } catch (URISyntaxException e) {
	           e.printStackTrace();
	       }
		 
		 RestTemplate restTemplate = new RestTemplate();
		 KTravelDto result = restTemplate.getForObject(uri, KTravelDto.class);
		 
		model.addAttribute("numOfRows", numOfRows);
		model.addAttribute("pageNo", pageNo);
		System.out.println("numOfRows");
		System.out.println("pageNo");
//			throws UnsupportedEncodingException {
//		try {
//			//// 우리나라 공공 api ////
//			// 인코딩 인증키
//			String API_KEY = "rR3aTQuk9UBRlPeuThbhKGD81oaxjq2d0L68RpPLHGTsNCGPZW98BtLBG228F8z8HNB82aLxS3Iljaeed5oKkQ==";
////		String API_KEY2 = "rR3aTQuk9UBRlPeuThbhKGD81oaxjq2d0L68RpPLHGTsNCGPZW98BtLBG228F8z8HNB82aLxS3Iljaeed5oKkQ%3D%3D";
//
//			String API_URL = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?numOfRows=10&pageNo="+ currentPage +"&MobileOS=ETC&MobileApp=AppTest&arrange=B&_type=json&serviceKey="
//					+ API_KEY;
//			// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
//			RestTemplate restTemplate = new RestTemplate();
//
//			URI uri = new URI(API_URL);
//
//			KTravelDto kt = restTemplate.getForObject(uri, KTravelDto.class); // 자기 클래스로 바꾸시오..
//			log.info("==== json ==== : 잘불러오나? : " + kt.response.body.totalCount);
//			String location = kt.response.body.items.item.get(0).galPhotographyLocation;
//			String title = kt.response.body.items.item.get(0).galTitle;
//			String photo = kt.response.body.items.item.get(0).galPhotographer;
//			String ddara = String.format("==== json ==== :  이 지역은 %s에 있는 상호명 %s, 사진은 %s", location, title, photo);
//			log.info(ddara);
//
//			List<Item> itemList = kt.response.body.items.item;
//			model.addAttribute("list", itemList);
//		} catch (URISyntaxException e) {
//			log.error("Failed to process the request: " + e.getMessage());
//		}
	}
}
