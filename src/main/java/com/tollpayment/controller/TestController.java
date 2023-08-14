
package com.tollpayment.controller;

import com.tollpayment.constants.ApiConstants;
import com.tollpayment.models.Ride;
import com.tollpayment.models.User;
import com.tollpayment.payload.request.PaymentRequest;
import com.tollpayment.payload.request.RideRequest;
import com.tollpayment.payload.response.MessageResponse;
import com.tollpayment.repository.RideRepository;
import com.tollpayment.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rides")
public class TestController {
    @Autowired
    RideRepository rideRepository;
    @Autowired
    UserRepository userRepository;

    /*
    User ONLY APIS
     */
    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createRide(@Valid @RequestBody RideRequest rideRequest) {
        System.out.println(rideRequest);
        // Create new ride
        Ride ride = new Ride(rideRequest.getEntry_time(), rideRequest.getExit_time(),
                rideRequest.getDistance(), rideRequest.getSpeed(), rideRequest.getRide_fee(), rideRequest.getFine(),
                rideRequest.getTotal_fee(), rideRequest.getStart_balance(), rideRequest.getRemaining_balance(),
                rideRequest.getTransaction_time(), rideRequest.getTransaction_status());

        User user = userRepository.findById(rideRequest.getUser_id())
                .orElseThrow(() -> new UsernameNotFoundException("Ride Not Found with ID: " + rideRequest.getUser_id()));

        ride.setUser(user);
        rideRepository.save(ride);
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "Ride added successfully!", null));
    }

    @GetMapping("/ridesperuser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllRidesForUser(@RequestParam("userId") String userId) {
        List<Ride> userRides = new ArrayList<>();
        List<Ride> rideList = rideRepository.findAll();
        System.out.println(rideList);
        for (int i = 0; i < rideList.size(); i++) {
            System.out.println(i);
            Ride ride = rideList.get(i);
            if (ride.getUser().getId().equals(userId)) {
                userRides.add(ride);
            }
        }
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "Rides fetched successfully!", userRides));
    }

    @PutMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateRide(@Valid @RequestBody PaymentRequest paymentRequest) {
        System.out.println("AWA");
        Ride ride = rideRepository.findById(paymentRequest.getId())
                .orElseThrow(() -> new UsernameNotFoundException("Ride Not Found with ID: " + paymentRequest.getId()));
        ride.setTransaction_time(paymentRequest.getTransaction_time());

        //Update wallet balance of the user
        try {
            User user = ride.getUser();
            User userModel = userRepository.findById(user.getId())
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with ID: " + user.getId()));
            Double currentWallet = userModel.getWallet();
            Double remainingWallet = currentWallet - paymentRequest.getPayment();
            userModel.setWallet(remainingWallet);
            userRepository.save(userModel);
            ride.setStart_balance(currentWallet);
            ride.setRemaining_balance(remainingWallet);
            ride.setTransaction_status("Success");

        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(ApiConstants.STATUS_FAILED, "Something went wrong!", null));
        }

        //Update ride
        rideRepository.save(ride);
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "Ride updated successfully!", ride));
    }

    /*
    Admin Only APIs
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllRides() {
        List<Ride> rideList = rideRepository.findAll();
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "Rides fetched successfully!", rideList));
    }

}
