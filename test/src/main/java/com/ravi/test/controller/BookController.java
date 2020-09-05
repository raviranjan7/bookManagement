package com.ravi.test.controller;

import com.ravi.test.pojo.BookRequest;
import com.ravi.test.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PutMapping(value = "/book/{bookId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateBook(@PathVariable String bookId,
                           @RequestBody BookRequest bookRequest){
        bookService.updateBook(bookId, bookRequest);
    }
}
