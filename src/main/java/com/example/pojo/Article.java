package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor

public class Article {

    private Integer id;
    private String title;
    private String summary;
    private Date createTime;

    public Article(Integer id, String title, String summary) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.createTime = new Date();
    }






}
