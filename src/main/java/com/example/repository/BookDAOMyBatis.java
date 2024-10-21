package com.example.repository;

import com.example.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.HashMap;
import java.util.List;

public class BookDAOMyBatis { // 리팩토링 => 중앙집중식 관리, 코드의 간결성, 자원의관리의 효율성

        public List<BookDTO> bookList(Criteria criteria){
            try(SqlSession session=MyBatisUtil.openSession()){ // close()
                 return session.selectList("bookList", criteria);
            }
        // try 블록이 종료되면 session은 자동으로 close 됩니다.
       }

       public int bookDelete(int num){
             try(SqlSession session=MyBatisUtil.openSession()){
                   int cnt=session.delete("bookDelete", num);
                   session.commit(); // 완료
                   return cnt;
             }
       }

       public int bookInsert(BookDTO dto){
           try(SqlSession session=MyBatisUtil.openSession()){
               int cnt=session.insert("bookInsert", dto);
               session.commit(); // 완료
               return cnt;
           }
       }

       public BookDTO bookView(int num){
           try(SqlSession session=MyBatisUtil.openSession()){
               BookDTO dto=session.selectOne("bookView", num);
               return dto;
           }
       }

    public int bookUpdate(BookDTO dto) {
        try(SqlSession session=MyBatisUtil.openSession()){
            int cnt=session.insert("bookUpdate", dto);
            session.commit(); // 완료
            return cnt;
        }
    }

    public int totalCount(){
            try(SqlSession session=MyBatisUtil.openSession()){
                  return session.selectOne("totalCount"); // 106
            }
    }

    public void excelInsert(Workbook wb) {
        Sheet sheet =wb.getSheetAt(0); // BookDTO
        try(SqlSession session=MyBatisUtil.openSession()){
            for( Row row : sheet){
                if(row.getRowNum()==0) continue;
                // 스타트 스프링	40000	스프링	500
                BookDTO dto=new BookDTO();
                dto.setTitle(row.getCell(0).getStringCellValue()); // 제목
                dto.setPrice((int)(row.getCell(1).getNumericCellValue())); // 가격
                dto.setAuthor(row.getCell(2).getStringCellValue()); // 저자
                dto.setPage((int)(row.getCell(3).getNumericCellValue())); // 페이지
                session.insert("bookInsert", dto); //SQL
            }
            session.commit(); // 완료
        }//
    }

    public int addToCart(CartDTO cartDTO) {
        try(SqlSession session=MyBatisUtil.openSession()){
            int cnt=session.insert("addToCart", cartDTO);
            session.commit(); // 완료
            return cnt;
        }
    }
   // 장바구니리스트
    public List<CartBookDTO> cartList(String customerId) {
            try(SqlSession session=MyBatisUtil.openSession()) {
                return session.selectList("cartList", customerId);
            }
    }

    public void removeCart(int cartNumber) {
        try(SqlSession session=MyBatisUtil.openSession()){
            session.insert("removeCart", cartNumber);
            session.commit(); // 완료
        }
    }

    public void quantityUpdate(int cartNumber, int quantity) {
        try(SqlSession session=MyBatisUtil.openSession()){
            HashMap<String, Integer> maps=new HashMap<>();
            maps.put("cartNumber", cartNumber);
            maps.put("quantity", quantity);
            session.update("quantityUpdate", maps);
            session.commit(); // 완료
        }
    }
}
