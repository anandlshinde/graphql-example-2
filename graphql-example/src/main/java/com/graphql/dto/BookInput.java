package com.graphql.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;

@Getter
@Setter
public class BookInput {
    private String name;
    private String description;
    private double price;
    private String author;
    private int pages;
    @Type(type = "jsonb")
    private String attributes;
}
