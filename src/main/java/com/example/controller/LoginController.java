package com.example.controller;

import com.example.entity.CustomerDTO;
import com.example.repository.LoginDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController  implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                                                                                throws ServletException, IOException {
        // 아이디, 패스워드 받아서 처리하는 부분....
        String customer_id=req.getParameter("customer_id");
        String password=req.getParameter("password");

        // CustomerDTO
        CustomerDTO dto=new CustomerDTO();
        dto.setCustomer_id(customer_id);
        dto.setPassword(password);
        // DAO
        LoginDAOMyBatis dao=new LoginDAOMyBatis();
        CustomerDTO cus=dao.login(dto);
        if(cus!=null){ //회원인증에 성공
            HttpSession session=req.getSession();
            session.setAttribute("cus", cus); // ${!cus empty}
        }
        return "redirect:/list.do";
    }
}
