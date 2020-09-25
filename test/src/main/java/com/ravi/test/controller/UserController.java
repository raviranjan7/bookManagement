package com.ravi.test.controller;

import com.ravi.test.data.model.User;
import com.ravi.test.pojo.UserRequest;
import com.ravi.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PutMapping(value = "/user/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUser(@PathVariable String userId,
                           @RequestBody UserRequest userRequest){
        userService.updateUser(userId, userRequest);
    }
//
//    @Autowired
//    private UserService userService1;

    ////ye baad me kiya hua hai.
    @GetMapping(value = "/login/{email}")
    public User getLoginUser(@PathVariable String email){
        return userService.getLoginUser(email);
    }
}
