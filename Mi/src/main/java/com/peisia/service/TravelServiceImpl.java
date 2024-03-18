package com.peisia.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.Item;
import com.peisia.dto.KTravelDto;
import com.peisia.dto.PageingVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TravelServiceImpl implements TravelService{
	
	private int limitIndex = 10;
	KTravelDto kt = null;

	@Override
	public List<Item> getList(int currentPage) {
	try {
		//// 우리나라 공공 api ////
		// 인코딩 인증키
		String API_KEY = "rR3aTQuk9UBRlPeuThbhKGD81oaxjq2d0L68RpPLHGTsNCGPZW98BtLBG228F8z8HNB82aLxS3Iljaeed5oKkQ==";
//	    String API_KEY2 = "rR3aTQuk9UBRlPeuThbhKGD81oaxjq2d0L68RpPLHGTsNCGPZW98BtLBG228F8z8HNB82aLxS3Iljaeed5oKkQ%3D%3D";
		
		String API_URL = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?numOfRows=" + limitIndex + "&pageNo="+ currentPage +"&MobileOS=ETC&MobileApp=AppTest&arrange=B&_type=json&serviceKey="
				+ API_KEY;
		System.out.println(API_URL);
		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI(API_URL);

		kt = restTemplate.getForObject(uri, KTravelDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 잘불러오나? : " + kt.response.body.totalCount);
		String location = kt.response.body.items.getItem().get(0).galPhotographyLocation;
		String title = kt.response.body.items.getItem().get(0).galTitle;
		String photo = kt.response.body.items.getItem().get(0).galPhotographer;
		String ddara = String.format("==== json ==== :  이 지역은 %s에 있는 상호명 %s, 사진은 %s", location, title, photo);
		log.info(ddara);
	} catch (URISyntaxException e) {
		log.error("Failed to process the request: " + e.getMessage());
		System.out.println("널포인트");
	}
		return kt.response.body.items.getItem();
	}

	@Override
	public PageingVO pageingList(int currentPage) {
		PageingVO aa = null;
		log.info("비지니스 계층===========");
		
		
		//이거 안씀 이거 조건이 원래 리미트문 시작할때 0부터 시작하는데 시작 못하게 1로 고정시키기 위해서 즉 pagenum 파라미터 값 받을때 
		//원래 null값받는데 이걸 1로 고정시키기 위해서 쓰는거였으나 이미 이전에서 후처리를 해놨음
		int startIndex = (currentPage - 1) * limitIndex; // 이거도 매핑해야돼
		if (startIndex == 0) {
			startIndex = 1;
		}
		//리미트 문을 위해서 페이징하는거였으나 이거는 페이징을 위해서만 실행함
		int totalpaging = (int) Math.ceil((double) getPageCount() / limitIndex);
//		
//		//이거는 블럭끼리 구분하기 위해서 계산
//		int totalblock = (int) Math.ceil((double) totalpaging / limitIndex);
//		
//		//현재 본인이 위치한 블럭을 구하기 위해서 계산
//		int nowBlockNo = (int) Math.ceil((double) currentPage / limitIndex);
//		
//		//블록 스타트 넘버 계산
//		int blockStartNo = (nowBlockNo - 1) * limitIndex + 1;
//		
//		//블록 끝 번호 계산
//		int blockEndNo = nowBlockNo * limitIndex;
//		
//		//if 조건문 전체 페이징된 숫자가 끝번호보다 작으면 끝번호는 페이징된 번호가 됨
//		if (blockEndNo > totalpaging) {
//			blockEndNo = currentPage;
//		}
//		
//		int loadprevPage = 0;
//		int loadnextPage = 0;
//		boolean hasPrev = true;
//		boolean hasNext = true;
//		
//		if (nowBlockNo <= 1) {
//			hasPrev = false;
//		} else {
//			hasPrev = true;
//			int prevPage = (nowBlockNo - 1) * limitIndex;
//			// 블럭으로 이도앟기 위해서 만든 함수
//			loadprevPage = prevPage;
//		}
//
//		if (nowBlockNo < totalblock) {
//			hasNext = true;
//			int nextPage = nowBlockNo * limitIndex + 1;
//			// 블럭으로 이동하기위해서 만든 함수
//			loadnextPage = nextPage;
//		} else {
//			hasNext = false;
//		}
//		// 생성자 함수에 새로운 생성자 함수를 선언한 뒤 넣기
//		aa = new PageingApiVO(
//             startIndex
//             );
//		반환
       return aa;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		log.info("======오류");
		return kt.response.body.items.getTotalCount();
	}

}
