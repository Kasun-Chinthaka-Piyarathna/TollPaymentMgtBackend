package com.tollpayment.payload.request;

public class RideRequest {

    private String user_id;


    private String entry_time;


    private String exit_time;


    private Double distance;


    private Double speed;


    private Double ride_fee;


    private Double fine;


    private Double total_fee;

    private Double start_balance;

    private Double remaining_balance;

    private String transaction_time;

    private String transaction_status;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
