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

import java.util.ArrayList;
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
    public void updateReserve(String userId, String bookId){
        User user = userRepository.findByUserId(userId);
        Book book = bookRepository.findByBookId(bookId);
        //check if bookId and userId exists in the db or not.
        if(user!= null && book!= null){
            List<Reserve> reserveList = reserveRepository.findAllByUserId(userId);
            //what if multiple with the same userId, can get count<=3 here only.
            //Also, check if the quantity is grater than 1.
//            int sameReserve = 0;
//            for(Reserve reserve: reserveList){
//                if(reserve.getBookId() == bookId) sameReserve = 1;
//            }
            if(reserveList.size()<3){

                Calendar calendar = Calendar.getInstance();
                Long reserveTime = calendar.getTimeInMillis();
                //To check if any user with this book reserved has exceed 2 week period.
                //If yes, then update the timestamp and update the userId of that book.
                List<Reserve> reserveList1 = reserveRepository.findAllByBookId(bookId);
                for(Reserve reserve: reserveList1){
                    if((reserveTime - reserve.getReserveTime())> 1209600000){
                        reserve.setReserveTime(reserveTime);
                        reserve.setUserId(userId);
                        reserveRepository.save(reserve);
                    }
                }
                if(book.getQuantity()>0){
                    Long quantity = book.getQuantity();
                    if(quantity == 1) book.setAvailabilityStatus("no");
                    book.setQuantity(quantity-1);
                    bookRepository.save(book);
                    Reserve temp= new Reserve(userId, bookId, reserveTime);
                    reserveRepository.save(temp);
                    //immediately need to reduce quantity. need fn to call bookController(by code not controller) using method resttemplate.

                }
            }
        }
        //then reserve if all conditions true or else return an error message.
        //return response if any conditons fail(500 here)
        //Reserve temp = reserveRequest.convertToReserve(userId);

    }

    public List<Book> getReservedBooks(String userId){
        List<Reserve> reserves = reserveRepository.findAllByUserId(userId);
        List<Book> reservedBooks = new ArrayList<Book>();
        for(Reserve r : reserves){
            String b = r.getBookId();
            Book temp = bookRepository.findByBookId(b);
            reservedBooks.add(temp);
        }
        return reservedBooks;
    }
}
