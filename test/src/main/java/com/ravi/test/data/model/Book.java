package com.ravi.test.data.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
@Getter
@Setter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long sid;
    @Column(name = "book_id", nullable = false)
    private String bookId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @Column(name = "availability_status", nullable = false)
    private String availabilityStatus;

    public Book(String bookId, String name, String category, long quantity, String availabilityStatus) {
        this.bookId = bookId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.availabilityStatus = availabilityStatus;
    }
}
