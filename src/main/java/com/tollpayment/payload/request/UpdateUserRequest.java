package com.tollpayment.payload.request;

public class UpdateUserRequest {

    private String id;
    private Double wallet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
