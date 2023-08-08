package com.tollpayment.models;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rides")
public class Ride {
    @Id
    private String id;

    @DBRef
    @NotBlank
    private User user;

    @NotBlank
    private String entry_time;

    @NotBlank
    private String exit_time;

    @NotBlank
    private String distance;

    @NotBlank
    private String speed;

    @NotBlank
    private String ride_fee;

    @NotBlank
    private String fine;

    @NotBlank
    private String total_fee;

    @NotBlank
    private String transaction_time;

    @NotBlank
    private String transaction_status;

    public Ride() {
    }

    public Ride(String entryTime, String exitTime, String distance,
                String speed, String rideFee, String fine, String totalFee, String transactionTime,
                String transactionStatus) {
        this.entry_time= entryTime;
        this.exit_time=exitTime;
        this.distance= distance;
        this.speed=speed;
        this.ride_fee=rideFee;
        this.fine = fine;
        this.total_fee = totalFee;
        this.transaction_time=transactionTime;
        this.transaction_status=transactionStatus;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getExit_time() {
        return exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRide_fee() {
        return ride_fee;
    }

    public void setRide_fee(String ride_fee) {
        this.ride_fee = ride_fee;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(String transaction_time) {
        this.transaction_time = transaction_time;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}