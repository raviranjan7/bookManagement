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

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {
    private String name;
    private String category;
    private long quantity;
    public BookRequest(String name, String category, long quantity, String availabilityStatus) {
		super();
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.availabilityStatus = availabilityStatus;
	}

	private String availabilityStatus;


    public Book convertToBook(Long sid, String bookId) {
        return new Book(sid, bookId, this.name, this.category, this.quantity, this.availabilityStatus);
    }


    public Book convertToBook(String bookId) {
        return new Book(bookId, this.name, this.category, this.quantity, this.availabilityStatus);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
