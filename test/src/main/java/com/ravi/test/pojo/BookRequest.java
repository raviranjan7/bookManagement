package com.ravi.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ravi.test.data.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {
    private String name;
    private String category;
    private long quantity;
    private String availabilityStatus;
    public Book convertToBook(Long sid, String bookId) {
        return new Book(sid, bookId, this.name, this.category, this.quantity, this.availabilityStatus);
    }
    public Book convertToBook(String bookId) {
        return new Book(bookId, this.name, this.category, this.quantity, this.availabilityStatus);
    }
}
