package com.graphql.dto;

import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Map;

@Data
public class BookReponseModel {
    private String name;
    private String description;
    private double price;
    private String author;
    private int pages;
    private Map<String,Object> attributes;
}
