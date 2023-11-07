package com.graphql.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.graphql.entity.Book;
import com.graphql.repository.BookRepository;
import com.graphql.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public Book saveBook(Book book) {
        ObjectMapper objectMapper=new ObjectMapper();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "studytonight");
            jsonObject.put("address", "Noida");
        //book.setAttributes(jsonObject.toString());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        Optional<Book> bookObj = bookRepository.findById(id);
        Book book = bookObj.get();
       /* book.setAttributes("{\\\"size\\\": {\n" +
                "                                     \\\"name\\\": \\\"Large\\\",\n" +
                "                                     \\\"description\\\": \\\"This is custom attribute description\\\",\n" +
                "                                     \\\"unit\\\": \\\"This is custom attribute unit\\\"\n" +
                "                                    },\n" +
                "                   \\\"attribute_1\\\": {\n" +
                "                                     \\\"name\\\": \\\"Attribute1 name\\\",\n" +
                "                                     \\\"description\\\": \\\"This is custom attribute description\\\",\n" +
                "                                     \\\"unit\\\": \\\"This is custom attribute unit\\\"\n" +
                "                                    }\n" +
                "                        }");*/
        //book.setAttributes("{\\\"name\\\":\\\"studytonight\\\",\\\"address\\\":\\\"Noida\\\"}");

        return bookObj;
    }
}
