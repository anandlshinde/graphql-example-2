package com.graphql.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInput {
    private String name;
    private String description;
    private double price;
    private String author;
    private int pages;
    @JsonFormat
    private String attributes;
}
