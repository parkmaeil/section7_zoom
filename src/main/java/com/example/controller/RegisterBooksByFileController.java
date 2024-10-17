package com.example.controller;

import com.example.repository.BookDAOMyBatis;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterBooksByFileController implements  Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 엑셀파일을 받아서 처리하는 부분....
        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(req); // 멀티?
            FileItem item=items.get(0);
            System.out.println(item.getName()); // ? .xls
            Workbook wb = WorkbookFactory.create(item.getInputStream());
            System.out.println(wb.getSheetAt(0).getSheetName()); // ???
            Sheet sheet=wb.getSheetAt(0);
            System.out.println("getPhysicalNumberOfRows :"+sheet.getPhysicalNumberOfRows()); //4
            System.out.println("getFirstRowNum :"+sheet.getFirstRowNum()); // 0(index : 0~)
            System.out.println("getLastRowNum :"+sheet.getLastRowNum()); // i<=3(index : 0~)
            Row row=sheet.getRow(0);
            System.out.println("getPhysicalNumberOfCells :"+row.getPhysicalNumberOfCells()); // 4
            System.out.println("getFirstCellNum : "+row.getFirstCellNum()); // 0
            System.out.println("getLastCellNum : "+row.getLastCellNum()); // j<4(-1)
            // 추가
            BookDAOMyBatis dao=new BookDAOMyBatis();
            dao.excelInsert(wb); // 저장성공
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/list.do";
    }
}
