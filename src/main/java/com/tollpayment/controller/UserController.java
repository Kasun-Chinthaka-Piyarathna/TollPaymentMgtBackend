package com.tollpayment.controller;

import com.tollpayment.model.loginPayload;
import com.tollpayment.model.Response;
import com.tollpayment.model.User;
import com.tollpayment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @PostMapping("/signin")
        @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> loginUser(@RequestBody loginPayload data){
        User user = service.getUser(data);
        Response response = new Response();
        if(user == null){
            response.setStatus("Failed");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        response.setStatus("Success");
        response.setData(user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
