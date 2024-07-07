package com.example.controller;

import com.example.entity.CustomerDTO;
import com.example.repository.LoginDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                                                                                throws ServletException, IOException {

        HttpSession session=req.getSession();
        session.invalidate(); //  로그아웃
        return "redirect:/list.do";
    }
}
