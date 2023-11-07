package com.graphql.api.graphql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.dto.BookInput;
import com.graphql.dto.BookReponseModel;
import com.graphql.entity.Book;
import com.graphql.mapper.BookMapper;
import com.graphql.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
@AllArgsConstructor
public class BookGpController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        return bookService.saveBook(bookMapper.bookInputToBook(book));
    }

    @QueryMapping("allBooks")
    public List<Book> getBook() {
    return bookService.getBookList();
    }

    @QueryMapping("getBook")
    public BookReponseModel getBook(@Argument int bookId) throws JsonProcessingException {
        Optional<Book> response = bookService.getBookById(bookId);
        BookReponseModel bookReponseModel=new BookReponseModel();
        bookReponseModel.setName(response.get().getName());
        Map<String, Object> mapping = new ObjectMapper().readValue(response.get().getAttributes(), HashMap.class);
        bookReponseModel.setAttributes(mapping);
        return bookReponseModel;
    }

//https://github.com/graphql-java-generator/GraphQL-Forum-Maven-Tutorial-server

}
/*
@Getter
@Setter
 class BookInput {
    private String name;
    private String description;
    private double price;
    private String author;
    private int pages;
}*/
