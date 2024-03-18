package com.peisia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.dto.GuestDto;
import com.peisia.dto.PageingVO;
import com.peisia.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	
	
//	@Override
//	public ArrayList<GuestDto> getList() {
//		log.info("비지니스 계층===========");
//		return mapper.getList();
//	}
	
	//페이징 적용
	@Override
	public List<GuestDto> getList(int currentPage) {
		log.info("비지니스 계층===========");
		int limitIndex = (currentPage-1) * 5;
		return mapper.getList(limitIndex);
	}
	//영민이가 넣음
	public int getPageCount() {
		return mapper.getPageCount();
	}
	@Override
    public PageingVO pageingList(int currentPage) {
		
		// PageingVO 라는 클래스 를 초기화시킴
		PageingVO aa = null;
		log.info("비지니스 계층===========");
		//이거 안씀 이거 조건이 원래 리미트문 시작할때 0부터 시작하는데 시작 못하게 1로 고정시키기 위해서 즉 pagenum 파라미터 값 받을때 
		//원래 null값받는데 이걸 1로 고정시키기 위해서 쓰는거였으나 이미 이전에서 후처리를 해놨음
		int startIndex = (currentPage - 1) * 5; // 이거도 매핑해야돼
		if (startIndex == 0) {
			startIndex = 1;
		}
		//리미트 문을 위해서 페이징하는거였으나 이거는 페이징을 위해서만 실행함
		int totalpaging = (int) Math.ceil((double) getPageCount() / 5);
		
		//이거는 블럭끼리 구분하기 위해서 계산
		int totalblock = (int) Math.ceil((double) totalpaging / 5);
		
		//현재 본인이 위치한 블럭을 구하기 위해서 계산
		int nowBlockNo = (int) Math.ceil((double) currentPage / 5);
		
		//블록 스타트 넘버 계산
		int blockStartNo = (nowBlockNo - 1) * 5 + 1;
		
		//블록 끝 번호 계산
		int blockEndNo = nowBlockNo * 5;
		
		//if 조건문 전체 페이징된 숫자가 끝번호보다 작으면 끝번호는 페이징된 번호가 됨
		if (blockEndNo > totalpaging) {
			blockEndNo = currentPage;
		}
		
		int loadprevPage = 0;
		int loadnextPage = 0;
		boolean hasPrev = true;
		boolean hasNext = true;
		
		if (nowBlockNo <= 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
			int prevPage = (nowBlockNo - 1) * 5;
			// 블럭으로 이도앟기 위해서 만든 함수
			loadprevPage = prevPage;
		}

		if (nowBlockNo < totalblock) {
			hasNext = true;
			int nextPage = nowBlockNo * 5 + 1;
			// 블럭으로 이동하기위해서 만든 함수
			loadnextPage = nextPage;
		} else {
			hasNext = false;
		}
		// 생성자 함수에 새로운 생성자 함수를 선언한 뒤 넣기
		aa = new PageingVO(
             startIndex,
             totalblock,
             nowBlockNo,
             blockStartNo,
             blockEndNo,
             loadprevPage,
             loadnextPage,
             hasPrev,
             hasNext
             );
		//반환
       return aa;
    }
	//영민이가 넣음
	
	@Override
	public GuestDto read(long bno) {
		return mapper.read(bno);
	}
	
	@Override
	public void del(long bno) {
		mapper.del(bno);
	}
	
	@Override
	public void write(GuestDto dto) {
		mapper.write(dto);
	}
	
	@Override
	public void modify(GuestDto dto) {
		mapper.modify(dto);
	}
}
