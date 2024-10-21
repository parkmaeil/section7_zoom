package com.example.controller;

import com.example.entity.CartBookDTO;
import com.example.entity.CartDTO;
import com.example.entity.CustomerDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartListController implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String customer_id=req.getParameter("customer_id");
        // 세선에서 로그인한 회원의 아이디를 가져오는 방법?
        HttpSession session=req.getSession();
        CustomerDTO dto = (CustomerDTO) session.getAttribute("cus");
        String customer_id=dto.getCustomer_id();

        BookDAOMyBatis dao=new BookDAOMyBatis();
        List<CartBookDTO> cartList=dao.cartList(customer_id);

        req.setAttribute("cartList", cartList);
        return "cartList"; // cartList.jsp
    }
}
