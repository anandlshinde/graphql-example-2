package com.graphql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "project_Books")
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String  author;
    private double price;
    private int pages;
    @Column(name = "attributes",columnDefinition = "json")
    private String attributes;
}
