package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewDTO {
    private Long reviewId;
    private Long book_num;
    private double rating;
    private String content;
    private Date created_at;
    // Constructors, getters, and setters...
}
