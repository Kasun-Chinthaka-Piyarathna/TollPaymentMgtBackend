
package com.tollpayment.controller;

import com.tollpayment.constants.ApiConstants;
import com.tollpayment.models.User;
import com.tollpayment.payload.request.UpdateUserRequest;
import com.tollpayment.payload.response.MessageResponse;
import com.tollpayment.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

	/*
	User Only APIs
	*/

    @GetMapping("/getuser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUser(@RequestParam("userId") String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with ID: " + userId));
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "User found!", user));
    }

	/*
	Admin Only APIs
	*/

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        List<User> userlist = userRepository.findAll();
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "All users fetched successfully!", userlist));
    }

    @PutMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with ID: " + updateUserRequest.getId()));
        user.setWallet(updateUserRequest.getWallet());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse(ApiConstants.STATUS_SUCCESS, "User updated successfully!", user));
    }

}
