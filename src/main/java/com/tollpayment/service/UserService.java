package com.tollpayment.service;

import com.tollpayment.model.Ride;
import com.tollpayment.model.loginPayload;
import com.tollpayment.model.User;
import com.tollpayment.repository.RideRepository;
import com.tollpayment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(user);
    }

    public User getUser(loginPayload data){
        return  repository.findByUsernameAndPassword(data.getUsername(), data.getPassword());
    }



}
