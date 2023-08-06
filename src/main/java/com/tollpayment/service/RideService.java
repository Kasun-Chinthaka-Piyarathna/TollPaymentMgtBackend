package com.tollpayment.service;

import com.tollpayment.models.Ride;
import com.tollpayment.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RideService {

    @Autowired
    private RideRepository repository;

    public Ride createRide(Ride ride) {
        ride.setRideId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(ride);
    }

    public List<Ride> findAllRides() {
        return repository.findAll();
    }


}
