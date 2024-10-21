package com.example.controller;

import com.example.entity.CartDTO;
import com.example.repository.BookDAOMyBatis;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCartController  implements  Controller{

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // JSON : {"book_num":28,"quantity":1,"customer_id":"user01"} ==>CartDTO
         // req.getParameter("book_num")
        ObjectMapper objectMapper=new ObjectMapper();
        CartDTO cartDTO=objectMapper.readValue(req.getInputStream(), CartDTO.class);

        BookDAOMyBatis dao=new BookDAOMyBatis();
        int count=dao.addToCart(cartDTO);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (count > 0) {
            // 적어도 하나의 행이 성공적으로 삽입되었을 때
            resp.getWriter().write("{\"success\": true}");
        } else {
            // 삽입된 행이 없을 때 (예를 들어, 입력 값이 유효하지 않아 삽입이 실패한 경우)
            resp.getWriter().write("{\"success\": false}");
        }

        return null;
    }
}
