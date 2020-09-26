package com.ravi.test.data.repository;

import com.ravi.test.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByBookId(String bookId);
    List<Book> findAll();
    Book save(Book book);
    //yaha se baad me hua hai.
    @Query("SELECT b FROM Book b WHERE CONCAT(b.name, b.category) LIKE %?1%")
    List<Book> search(String keyword);

}