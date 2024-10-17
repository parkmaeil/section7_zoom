package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.Criteria;
import com.example.entity.PageMaker;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookListController  implements  Controller{ // POJO
       public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                                           throws ServletException, IOException {

       // page=1, perPageNum=3
       Criteria criteria=new Criteria();
       if(req.getParameter("page") !=null){
           int page=Integer.parseInt(req.getParameter("page"));
           criteria.setPage(page);
       }
       if(req.getParameter("perPageNum") !=null){
               int perPageNum=Integer.parseInt(req.getParameter("perPageNum"));
               criteria.setPerPageNum(perPageNum);
       }

        //BookDAO dao=new BookDAO();
        //Model과연동하는 부분
        BookDAOMyBatis dao=new BookDAOMyBatis();

        List<BookDTO> list=dao.bookList(criteria);
       // 객체 바인딩 기술
        req.setAttribute("list", list); // ${list}

         PageMaker pm=new PageMaker();
         pm.setCri(criteria);
         pm.setTotalCount(dao.totalCount());
         req.setAttribute("pm", pm);
           // View와 연동하는 부분
        // forward, dispatcher
        //RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        //rd.forward(req, resp); //-------------------------------------------| ${list}
        return "list"; //  /WEB-INF/views/list.jsp
    }
}
