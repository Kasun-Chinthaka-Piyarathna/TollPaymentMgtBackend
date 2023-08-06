package com.tollpayment.repository;

import com.tollpayment.models.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<Ride,String> {


}
