//package com.ravi.test.pojo;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.ravi.test.data.model.Reserve;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//
//@Getter
//@Setter
//@Slf4j
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class ReserveRequest {
//    public String bookId;
//    public Reserve convertToReserve(Long sid, String userId, Long timeStamp){
//        return new Reserve(sid, userId, this.bookId);
//    }
//    public Reserve convertToReserve(String userId){
//        return new Reserve(userId, this.bookId);
//    }
//}
