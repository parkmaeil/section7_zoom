package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {  //{"book_num":28,"quantity":1,"customer_id":"user01"}
    private int cart_number;
    private String customer_id;
    private int book_num;
    private int quantity;
    private LocalDateTime cart_date;
}
