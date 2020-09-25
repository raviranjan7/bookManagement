package com.ravi.test.services;

import com.ravi.test.data.model.User;
import com.ravi.test.data.repository.UserRepository;
import com.ravi.test.pojo.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void updateUser(String userId, UserRequest userRequest){
        User user = userRepository.findByUserId(userId);
        if(user == null){
            User temp = userRequest.convertToUser(userId);
            userRepository.save(temp);
        }else{
            Long sid = user.getSid();
            User temp = userRequest.convertToUser(sid, userId);
            userRepository.save(temp);
        }

//        List<User> userList = userRepository.findAll();
//
//        if(userList.isEmpty()) {
//            User temp = userRequest.convertToUser(userId);
//            userRepository.save(temp);
//        }else{
//            User user = userRepository.findByUserId(userId);
//            Long sid = user.getSid();
//            User temp = userRequest.convertToUser(sid, userId);
//            userRepository.save(temp);
//        }
    }
    public String loginUser(String email, String password){
        User user = userRepository.findByEmail(email);
        String type = "";
        if(user!= null){
            if(user.getPassword().equals(password)) type = user.getType();
        }
        return type;
    }

    public User getLoginUser(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }
}