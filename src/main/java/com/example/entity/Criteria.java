package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
    private int page;
    private int perPageNum;
    public Criteria() {
        this.page=1;
        this.perPageNum=3; // ?
    }
    // 페이지가 지정이 되면 해당 페이지의 레코드의 시작번호(limit 시작번호(0,오프셋)
    public int getPageStart(){
        return (page-1)*perPageNum;
    }
}
