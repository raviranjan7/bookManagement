package com.ravi.test.controller;

//import com.ravi.test.pojo.ReserveRequest;
import com.ravi.test.data.model.Book;
import com.ravi.test.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReserveController {
    @Autowired
    private ReserveService reserveService;
    @PostMapping(value = "/reserve/book/{bookId}/user/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateReserve(@PathVariable String userId, @PathVariable String bookId){
        reserveService.updateReserve(userId, bookId);
        //return based on conditions
    }
    @GetMapping(value = "/reserve/{userId}")
    public List<Book> getReservedBooks(@PathVariable String userId){
        return reserveService.getReservedBooks(userId);
    }
}
