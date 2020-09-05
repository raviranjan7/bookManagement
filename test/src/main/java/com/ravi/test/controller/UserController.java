package com.ravi.test.controller;

import com.ravi.test.pojo.UserRequest;
import com.ravi.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PutMapping(value = "/user/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUser(@PathVariable String userId,
                           @RequestBody UserRequest userRequest){
        userService.updateUser(userId, userRequest);
    }
}
