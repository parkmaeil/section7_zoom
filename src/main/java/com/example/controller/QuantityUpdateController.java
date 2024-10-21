package com.example.controller;

import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuantityUpdateController implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int cartNumber=Integer.parseInt(req.getParameter("cartNumber"));
        int quantity=Integer.parseInt(req.getParameter("quantity"));

        BookDAOMyBatis dao=new BookDAOMyBatis();
        dao.quantityUpdate(cartNumber, quantity);
        return "redirect:/cartList.do";
    }
}
