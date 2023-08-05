package com.tollpayment.controller;

import com.tollpayment.model.*;
import com.tollpayment.service.RideService;
import com.tollpayment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RidesController {

    @Autowired
    private RideService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response> createUser(@RequestBody Ride ride){
        Ride newRide = service.createRide(ride);
        Response response = new Response();
        if(newRide == null){
            response.setStatus("Failed");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        response.setStatus("Success");
        response.setData(newRide);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response> getRides() {
        List<Ride> rides = service.findAllRides();
        Response response = new Response();
        if(rides == null){
            response.setStatus("Failed");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        response.setStatus("Success");
        response.setData(rides);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
