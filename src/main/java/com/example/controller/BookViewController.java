package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookViewController implements  Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                                                                                throws ServletException, IOException {

        int num=Integer.parseInt(req.getParameter("num"));

        BookDAOMyBatis dao = new BookDAOMyBatis();
        BookDTO book = dao.bookView(num);

        req.setAttribute("book", book);
        //RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
        //rd.forward(req, resp);
        return "view";
    }
}
