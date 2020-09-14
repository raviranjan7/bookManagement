package com.ravi.test.services;

import com.ravi.test.data.model.Book;
import com.ravi.test.data.model.Reserve;
import com.ravi.test.data.model.User;
import com.ravi.test.data.repository.BookRepository;
import com.ravi.test.data.repository.ReserveRepository;
//import com.ravi.test.pojo.ReserveRequest;
import com.ravi.test.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    public int updateReserve(String userId, String bookId){
        User user = userRepository.findByUserId(userId);
        Book book = bookRepository.findByBookId(bookId);
        //check if bookId and userId exists in the db or not.
        if(user!= null && book!= null){
            List<Reserve> reserveList = reserveRepository.findAllByUserId(userId);
            //what if multiple with the same userId, can get count<=3 here only.
            //Also, check if the quantity is grater than 1.

            if(reserveList.size()<3 && book.getQuantity()>0){
                Calendar calendar = Calendar.getInstance();
                Long reserveTime = calendar.getTimeInMillis();
                Long quantity = book.getQuantity();
                book.setQuantity(quantity-1);
                bookRepository.save(book);
                Reserve temp= new Reserve(userId, bookId, reserveTime);
                reserveRepository.save(temp);
                //immediately need to reduce quantity. need fn to call bookController(by code not controller) using method resttemplate.
                return 1;
            }
        }
        //then reserve if all conditions true or else return an error message.
        //return response if any conditons fail(500 here)
        //Reserve temp = reserveRequest.convertToReserve(userId);
        return 0;
    }
}
