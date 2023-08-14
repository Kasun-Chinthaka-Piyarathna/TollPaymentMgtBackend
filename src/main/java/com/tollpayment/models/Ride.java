package com.tollpayment.models;

import jakarta.validation.constraints.NotBlank;

import lombok.Builder;
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
    private Double distance;

    @NotBlank
    private Double speed;

    @NotBlank
    private Double ride_fee;

    @NotBlank
    private Double fine;

    @NotBlank
    private Double total_fee;


    private Double start_balance;

    private Double remaining_balance;
    @Builder.Default
    private String transaction_time = null;
    @Builder.Default
    private String transaction_status = null;

    public Ride() {
    }

    public Ride(String entryTime, String exitTime, Double distance,
                Double speed, Double rideFee, Double fine, Double totalFee, Double startBalance, Double remainBalance,
                String transactionTime,
                String transactionStatus) {
        this.entry_time = entryTime;
        this.exit_time = exitTime;
        this.distance = distance;
        this.speed = speed;
        this.ride_fee = rideFee;
        this.fine = fine;
        this.total_fee = totalFee;
        this.start_balance = startBalance;
        this.remaining_balance = remainBalance;
        this.transaction_time = transactionTime;
        this.transaction_status = transactionStatus;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getRide_fee() {
        return ride_fee;
    }

    public void setRide_fee(Double ride_fee) {
        this.ride_fee = ride_fee;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Double total_fee) {
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

    public Double getStart_balance() {
        return start_balance;
    }

    public void setStart_balance(Double start_balance) {
        this.start_balance = start_balance;
    }

    public Double getRemaining_balance() {
        return remaining_balance;
    }

    public void setRemaining_balance(Double remaining_balance) {
        this.remaining_balance = remaining_balance;
    }
}