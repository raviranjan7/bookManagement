package com.ravi.test.data.repository;

import com.ravi.test.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByBookId(String bookId);
    List<Book> findAll();
    Book save(Book book);
}