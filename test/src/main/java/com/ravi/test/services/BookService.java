package com.ravi.test.services;

import com.ravi.test.data.model.Book;
import com.ravi.test.data.repository.BookRepository;
import com.ravi.test.pojo.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void updateBook(String bookId, BookRequest bookRequest){
        List<Book> bookList = bookRepository.findAll();
        Book book = bookRepository.findByBookId(bookId);
        if(bookList.isEmpty()){
            Book temp = bookRequest.convertToBook(bookId);
            bookRepository.save(temp);
        }else{
            Long sid = book.getSid();
            Book temp = bookRequest.convertToBook(sid, bookId);
            bookRepository.save(temp);
        }
    }

}
