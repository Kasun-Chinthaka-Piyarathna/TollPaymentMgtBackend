package com.tollpayment.repository;

import com.tollpayment.model.Task;
import com.tollpayment.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUsernameAndPassword(String username, String password);

}
