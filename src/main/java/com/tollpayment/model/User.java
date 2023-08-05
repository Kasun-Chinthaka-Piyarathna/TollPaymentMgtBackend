package com.tollpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private String vehicleNumber;
    private String address;
    private String role;
    private double walletPoints;
}
