package com.tollpayment.repository;

import com.tollpayment.model.Ride;
import com.tollpayment.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<Ride,String> {


}
