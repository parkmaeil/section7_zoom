package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CartBookDTO {
    private int cart_number;
    private String customer_id;
    private int book_num;
    private int quantity;
    private LocalDateTime cart_date;

    private Long num;
    private String title;
    private int price;
    private String author;
    private int page;
}
