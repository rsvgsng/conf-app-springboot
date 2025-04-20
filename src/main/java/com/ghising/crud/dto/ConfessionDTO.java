package com.ghising.crud.dto;


import lombok.Data;

@Data
public class ConfessionDTO {
    private  String title;
    private String content;
    private String author;
    private  String createdAt;
}
