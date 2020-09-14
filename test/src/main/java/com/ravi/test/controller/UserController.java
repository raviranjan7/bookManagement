package com.ravi.test.controller;

import com.ravi.test.pojo.UserRequest;
import com.ravi.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping(value = "/login/email/{email}/password/{password}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity loginUser(@PathVariable String email, @PathVariable String password){
        int res = 0;
        res = userService.loginUser(email, password);
        //return based on conditions
        if(res == 1) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
