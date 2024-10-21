package com.example.controller;

import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveFromCartController implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int cart_number=Integer.parseInt(req.getParameter("cart_number"));
        BookDAOMyBatis dao=new BookDAOMyBatis();
        dao.removeCart(cart_number);

        return "redirect:/cartList.do";

    }
}
