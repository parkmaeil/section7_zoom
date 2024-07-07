package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BookRegisterGetController implements  Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                                           throws ServletException, IOException {

         HttpSession session=req.getSession(false);
         if(session.getAttribute("cus")==null){
             return "redirect:/list.do";
        }
        // View와 연동하는 부분
        // forward, dispatcher
        //RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        //rd.forward(req, resp);
       return "register";
    }
}
