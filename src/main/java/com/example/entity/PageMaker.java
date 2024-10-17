package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMaker {
       private Criteria cri;
       private int totalCount; // 전체 책의 수
       private int displayPageNum=3;
       private int startPage;
       private int endPage;
       private boolean prev; // true, false
       private boolean next; // true, false
      //                                                      106
       public void setTotalCount(int totalCount){
           this.totalCount=totalCount;
           calcPageMaker();
       }
       public void calcPageMaker(){
           // 12page=20
           endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
           startPage=(endPage-displayPageNum)+1;
           // 34page=40?
           // 36
           int tempEndPage=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
           if(endPage>tempEndPage){
               endPage=tempEndPage;
           }
           prev=(startPage!=1) ? true : false;
           next=(endPage<tempEndPage) ? true : false;
       }
}
