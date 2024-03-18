package com.peisia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.domain.GuestVO;
import com.peisia.domain.PageingVO;
import com.peisia.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	
	
	@Override
	public List<GuestVO> searchList(int currentPage,String searchword){
		GuestVO gvo = new GuestVO();
		int limitIndex = (currentPage-1)*5;
		gvo.setLimitIndex(limitIndex);
		gvo.setSearchword(searchword);
		return mapper.searchList(gvo);
	}
	@Override
	public int getPageCount(String searchword) {
		return mapper.getPageCount(searchword);
	}
	@Override
	public PageingVO pageingList(int currentPage,String searchword) {
		PageingVO page = new PageingVO();
	    log.info("비지니스 계층===========");
	    page.setSearchword(searchword);
		page.setTotalpage((int) Math.ceil((double) getPageCount(searchword) / 5));
		page.setTotalblock((int) Math.ceil((double) page.getTotalpage() / 5));
		page.setNowBlockNo((int) Math.ceil((double) currentPage / 5));
		page.setBlockStartNo((page.getNowBlockNo() - 1) * 5 + 1);
		page.setBlockEndNo(page.getNowBlockNo() * 5);
		
		if (page.getBlockEndNo() > page.getTotalpage()) {
			page.setBlockEndNo(page.getTotalpage());
		}
//		
//		if (page.getBlockEndNo() > page.getTotalpage()) {
//			page.setBlockEndNo(currentPage);
//		}
		
		if (page.getNowBlockNo() <= 1) {
			page.setHasPrev(false);
		} else {
			page.setHasPrev(true);
			int prevPage = (page.getNowBlockNo() - 1) * 5;
			page.setLoadprevPage(prevPage);
		}
		
		if (page.getNowBlockNo() < page.getTotalblock()) {
			page.setHasNext(true);
			int nextPage = page.getNowBlockNo() * 5 + 1;
			page.setLoadnextPage(nextPage);
		} else {
			page.setHasNext(false);
		}
		return page;
	   }
//	@Override
//	public PageingVO pageingList(int currentPage) {
//		PageingVO aa = null;
//		int totalpage = getPageCount();
//		log.info("비지니스 계층===========");
//		int startIndex = (currentPage-1)*5; // 이거도 매핑해야돼
//		if(startIndex == 0) {
//			startIndex = 1;
//		}
//		int totalblock = (int)Math.ceil((double)totalpage / 5);
//		int nowBlockNo = (int)Math.ceil((double)currentPage / 5);
//		int blockStartNo = (nowBlockNo-1) * 5 + 1;
//		int blockEndNo  = nowBlockNo * 5;
//		if(blockEndNo>totalblock) {
//			blockEndNo = totalblock;
//		}
//		int loadprevPage = 0;
//		int loadnextPage = 0;
//		boolean hasPrev = true;
//		boolean hasNext = true;
//		if(blockEndNo > totalpage) {
//			blockEndNo = currentPage;
//		}
//		if(nowBlockNo <= 1){	
//			hasPrev = false;
//		} else {					
//			hasPrev = true;
//			int prevPage = (nowBlockNo - 1 ) * 5;
//			loadprevPage = prevPage;
//		}
//		if(nowBlockNo < totalblock ){
//			hasNext = true;
//			int nextPage = nowBlockNo * 5 + 1;		
//			loadnextPage = nextPage;
//		} else {						
//			hasNext = false;
//		}
//			aa = new PageingVO(
//				startIndex,
//				totalblock,
//				nowBlockNo,
//				blockStartNo,
//				blockEndNo,
//				loadprevPage,
//				loadnextPage,
//				hasPrev,
//				hasNext
//				);
//		return aa;
//	}
	@Override
	public GuestVO read(long bno) {
		return mapper.read(bno);
	}

	@Override
	public void del(long bno) {
		mapper.del(bno);
	}

	@Override
	public void write(GuestVO gvo) {
		mapper.write(gvo);
	}

	@Override
	public void modify(GuestVO gvo) {
		mapper.modify(gvo);
	}
	
}
