package com.ravi.test.data.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long sid;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "book_id", nullable = false)
    private String bookId;
    @Column(name = "reserve_time", nullable = false)
    private Long reserveTime;

    public Reserve(String userId, String bookId, Long reserveTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.reserveTime = reserveTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setReserveTime(Long reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Long getReserveTime() {
        return reserveTime;
    }

    public String getBookId() {
        return bookId;
    }
}
