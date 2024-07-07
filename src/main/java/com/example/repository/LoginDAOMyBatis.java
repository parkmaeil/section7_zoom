package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.CustomerDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LoginDAOMyBatis { // 리팩토링 => 중앙집중식 관리, 코드의 간결성, 자원의관리의 효율성

       public CustomerDTO login(CustomerDTO dto){
        try(SqlSession session=MyBatisUtil.openSession()){ // close()
            return session.selectOne("com.example.repository.LoginDAOMyBatis.login", dto);
        }
    }
}
