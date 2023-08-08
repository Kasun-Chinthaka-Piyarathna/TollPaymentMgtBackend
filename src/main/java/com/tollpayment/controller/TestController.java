
package com.tollpayment.controller;

import com.tollpayment.constants.ApiConstants;
import com.tollpayment.models.ERole;
import com.tollpayment.models.Ride;
import com.tollpayment.models.Role;
import com.tollpayment.models.User;
import com.tollpayment.payload.request.PaymentRequest;
import com.tollpayment.payload.request.RideRequest;
import com.tollpayment.payload.request.SignupRequest;
import com.tollpayment.payload.response.MessageResponse;
import com.tollpayment.repository.RideRepository;
import com.tollpayment.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rides")
public class TestController {
	@Autowired
	RideRepository rideRepository;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createRide(@Valid @RequestBody RideRequest rideRequest) {
		System.out.println(rideRequest);
		// Create new ride
		Ride ride = new Ride(rideRequest.getEntry_time(),rideRequest.getExit_time(),
				rideRequest.getDistance(), rideRequest.getSpeed(), rideRequest.getRide_fee(),rideRequest.getFine(),
				rideRequest.getTotal_fee(),rideRequest.getTransaction_time(), rideRequest.getTransaction_status());

		User user = userRepository.findById(rideRequest.getUser_id())
				.orElseThrow(() -> new UsernameNotFoundException("Ride Not Found with ID: " + rideRequest.getUser_id()));

		ride.setUser(user);
		rideRepository.save(ride);
		return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS,"Ride added successfully!",null));
	}

	@GetMapping("all")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getAllRides() {
		List<Ride> rideList = rideRepository.findAll();
		return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS,"Ride added successfully!",rideList));
	}

	@PutMapping()
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> updateRide (@Valid @RequestBody PaymentRequest paymentRequest) {
		Ride ride  = rideRepository.findById(paymentRequest.getId())
				.orElseThrow(() -> new UsernameNotFoundException("Ride Not Found with ID: " + paymentRequest.getId()));
		ride.setTransaction_time(paymentRequest.getTransaction_time());
		ride.setTransaction_status(paymentRequest.getTransaction_status());
		rideRepository.save(ride);
		return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS,"Ride updated successfully!",ride));
	}

}
