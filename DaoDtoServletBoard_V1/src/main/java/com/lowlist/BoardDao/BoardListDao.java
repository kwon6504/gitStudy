package com.lowlist.BoardDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.lowlist.Dto.Dto;
import com.lowlist.Dto.DtoMember;
import com.lowlist.MasterClass.MasterDao;
import com.lowlist.MasterClass.TotalPage_Block;
import com.lowlist.MasterClass.Db;

//인서트 = 쿼리 기타 다른것 = 업데이트 안하면 에러남
public class BoardListDao extends MasterDao {
	//수정
	public void edit(Dto d,String no) {
		try {
			String sql = String.format(
					"UPDATE %s SET b_title='%s',b_content='%s' WHERE b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, d.title,d.content,no);
			super.update(sql);
			super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//리스트
	public ArrayList<Dto> list(String page){
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*TotalPage_Block.LIST_AMOUNT;
			String sql = String.format(
					"SELECT * FROM %s WHERE b_del_number=0 limit %s,%s"
					,Db.TABLE_PS_BOARD_FREE,startIndex,TotalPage_Block.LIST_AMOUNT);
			ResultSet rs = super.Query(sql);
				while(rs.next()) {
					posts.add(new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_content"),
						rs.getString("b_id"),
						rs.getString("b_del_number"),
						rs.getString("b_hit"),
						rs.getString("b_datetime"),
						rs.getString("b_comment_count"),
						rs.getString("b_commnet_ori")
							));
						}
					super.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		return posts;
	}
	//리스트 내에서 찾기
	public ArrayList<Dto> listsearch(String page,String word){
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*TotalPage_Block.LIST_AMOUNT;
			String sql = String.format(
					"SELECT * FROM %s WHERE b_del_number=0 and b_title like '%%%s%%' limit %s,%s"
					,Db.TABLE_PS_BOARD_FREE,word,startIndex,TotalPage_Block.LIST_AMOUNT);
			ResultSet rs = super.Query(sql);
				while(rs.next()) {
					posts.add(new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_content"),
						rs.getString("b_id"),
						rs.getString("b_del_number"),
						rs.getString("b_hit"),
						rs.getString("b_datetime"),
						rs.getString("b_comment_count"),
						rs.getString("b_commnet_ori")
							));
						}
					super.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		return posts;
	}
	//검색 기능
	public ArrayList<Dto> getArraySearch(String pagenum, String searchword ,int totalpage) {
		ArrayList<Dto> posts = null;
		if(searchword == null ||pagenum.equals("null")) {
			posts = list(pagenum);
			totalpage = totalPageCalculate();
		}else {
			posts = listsearch(pagenum,searchword);
			totalpage = totalSearchPageCalculate(searchword);
		}
		return posts;
	}
	//전체페이지계산 리턴문
	public int returnPageCal(String pagenum, String searchword ,int totalpage) {
		if(searchword == null ||pagenum.equals("null")) {
			totalpage = totalPageCalculate();
		}else {
			totalpage = totalSearchPageCalculate(searchword);
		}
		return totalpage;
	}
	//읽기
	public Dto read(String no) {
		Dto post = null;
		try {
			String sql = String.format(
					"SELECT * FROM %s WHERE b_no=%s"
					,Db.TABLE_PS_BOARD_FREE,no);
			ResultSet rs = super.Query(sql);
				if(rs.next()==true) {
					post =new Dto(
						rs.getString("b_no"),
						rs.getString("b_title"),
						rs.getString("b_content"),
						rs.getString("b_id"),
						rs.getString("b_del_number"),
						rs.getString("b_hit"),
						rs.getString("b_datetime"),
						rs.getString("b_comment_count"),
						rs.getString("b_commnet_ori")
					);
				super.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	//쓰기
	public void write(Dto d) {
		try {
			String sql = String.format(
					"INSERT INTO %s (b_title,b_id,b_content) VALUES ('%s','%s','%s')"
					,Db.TABLE_PS_BOARD_FREE, d.title,d.id,d.content);
				super.update(sql);
				super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//삭제
	public void del(String no) {
		try {
			String sql = "UPDATE dog_board SET b_del_number = 1 WHERE b_no="+no;
			super.update(sql);
			super.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//게시물 갯수 숫자로 반환
	public int getCountPost() {
		int count = 0;
		try {
			String sql = String.format("SELECT COUNT(*) FROM %s WHERE b_del_number=0 ",Db.TABLE_PS_BOARD_FREE);
			ResultSet rs = super.Query(sql);
			
			if(rs.next() == true) {
			count = rs.getInt("count(*)");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	//검색된 게시물 갯수 숫자로 반환
	public int getSearchCountPost(String word) {
		int count = 0;
		try {
			String sql = String.format
					("SELECT COUNT(*) FROM %s WHERE b_title like '%%%s%%' and b_del_number=0"
					,Db.TABLE_PS_BOARD_FREE,word);
			ResultSet rs = super.Query(sql);
			
			if(rs.next() == true) {
				count = rs.getInt("count(*)");
				}
		} catch(Exception e){
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	//전체 게시물 갯수에서 따로 지정했던 보여질 게시물 갯수를 계산하는 식
	public int totalPageCalculate() {
		int totalpagecount = 0;
		int count = getCountPost();
		if(count % TotalPage_Block.LIST_AMOUNT == 0 ) {
			totalpagecount = count / TotalPage_Block.LIST_AMOUNT;
		}else {
			totalpagecount = count / TotalPage_Block.LIST_AMOUNT + 1;
		}
		return totalpagecount;
	}
	
	//검색된 게시물 갯수에서 따로 지정했던 보여질 게시물 갯수를 계산하는 식
	public int totalSearchPageCalculate(String word) {
		int totalsearchpagecount = 0;
		int count = getSearchCountPost(word);
		if(count % TotalPage_Block.LIST_AMOUNT == 0 ) {
			totalsearchpagecount = count / TotalPage_Block.LIST_AMOUNT;
		}else {
			totalsearchpagecount = count / TotalPage_Block.LIST_AMOUNT + 1;
		}
		return totalsearchpagecount;
	}
	
	//페이징블럭 변수 반환식
	public Dto blockVariable(int pagenum,int totalpage) {
		Dto blocks = null;
		
		int totalblock = (int)Math.ceil((double)totalpage / TotalPage_Block.PAGE_LINK_AMOUNT);	
		int nowBlockNo = (int)Math.ceil((double)pagenum / TotalPage_Block.PAGE_LINK_AMOUNT);
		int blockStartNo = (nowBlockNo - 1) * TotalPage_Block.PAGE_LINK_AMOUNT + 1;
		int blockEndNo = nowBlockNo * TotalPage_Block.PAGE_LINK_AMOUNT;
		int loadprevPage = 0;
		int loadnextPage = 0;
		boolean hasPrev = true;
		boolean hasNext = true;
		
		System.out.println("토탈:시작"+totalblock);
		System.out.println("현재:시작"+nowBlockNo);
		System.out.println("시작:시작"+blockStartNo);
		System.out.println("끝:시작"+blockEndNo);

		if(blockEndNo > totalpage) {
			blockEndNo = totalpage;
		}
		if(nowBlockNo <= 1){	
			hasPrev = false;
		} else {					
			hasPrev = true;
			//????????? 역으로 해야지 작동됨 
			int prevPage = (nowBlockNo - 1 ) * TotalPage_Block.PAGE_LINK_AMOUNT;
			loadprevPage = prevPage;
		}
		if(nowBlockNo < totalblock ){	
			hasNext = true;	
			//????????? 역으로 해야지 작동됨 
			int nextPage = nowBlockNo * TotalPage_Block.PAGE_LINK_AMOUNT + 1;		
			loadnextPage = nextPage;
		} else {						
			hasNext = false;
		}
		blocks = new Dto(
				totalblock,
				nowBlockNo,
				blockStartNo,
				blockEndNo,
				loadprevPage,
				loadnextPage,
				hasPrev,
				hasNext
				);
		
		System.out.println("토탈"+totalblock);
		System.out.println("현재"+nowBlockNo);
		System.out.println("시작"+blockStartNo);
		System.out.println("끝"+blockEndNo);
		System.out.println("다음"+loadnextPage);
		System.out.println("이전"+loadprevPage);
		return blocks;
	}
	
}
