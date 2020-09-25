package com.ravi.test.controller;

import com.ravi.test.data.model.Book;
import com.ravi.test.pojo.BookRequest;
import com.ravi.test.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping(value = "/book/{bookId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateBook(@PathVariable String bookId,
                           @RequestBody BookRequest bookRequest){
        bookService.updateBook(bookId, bookRequest);
    }
    @GetMapping(value = "/book")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
