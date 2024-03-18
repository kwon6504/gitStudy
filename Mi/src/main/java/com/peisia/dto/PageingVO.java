package com.peisia.dto;

import lombok.Data;

//영민이가 넣음 
@Data
public class PageingVO {
   
   private String limitIndex;
   private int startIndex;
   private int totalpage;
   private int nowpage;
   private int totalblock;
   private int nextBlock;
   private int nowBlockNo;
   private int blockStartNo;
   private int blockEndNo;
   private int loadprevPage;
   private int loadnextPage;
   private boolean hasPrev;
   private boolean hasNext;

   //생성자함수
   public PageingVO(int startIndex, int totalblock, int nowBlockNo, int blockStartNo, int blockEndNo, int loadprevPage,
         int loadnextPage, boolean hasPrev, boolean hasNext) {
      this.startIndex = startIndex;
      this.totalblock = totalblock;
      this.nowBlockNo = nowBlockNo;
      this.blockStartNo = blockStartNo;
      this.blockEndNo = blockEndNo;
      this.loadprevPage = loadprevPage;
      this.loadnextPage = loadnextPage;
      this.hasPrev = hasPrev;
      this.hasNext = hasNext;
   }
}
